package com.zhazhapan.demo.netty.factorial;

import com.zhazhapan.demo.netty.common.constant.NettyConsts;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author pantao
 * @since 2018/6/6
 */
public class FactorialClientHandler extends SimpleChannelInboundHandler<BigInteger> {

    private final BlockingQueue<BigInteger> answer = new LinkedBlockingQueue<BigInteger>();

    private ChannelHandlerContext ctx;

    private int receivedMessages;

    private int next = 1;

    private final ChannelFutureListener numberSender = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) {
            if (future.isSuccess()) {
                sendNumbers();
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };

    BigInteger getFactorial() {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return answer.take();
                } catch (InterruptedException ignore) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        sendNumbers();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, final BigInteger msg) {
        receivedMessages++;
        if (receivedMessages == NettyConsts.FACTORIAL_COUNT) {
            // Offer the answer after closing the connection.
            ctx.channel().close().addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture future) {
                    boolean offered = answer.offer(msg);
                    assert offered;
                }
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private void sendNumbers() {
        // Do not send more than 4096 numbers.
        ChannelFuture future = null;
        for (int i = 0; i < NettyConsts.FACTORIAL_MAX_NUMBERS && next <= NettyConsts.FACTORIAL_COUNT; i++) {
            future = ctx.write(next);
            next++;
        }
        if (next <= NettyConsts.FACTORIAL_COUNT) {
            assert future != null;
            future.addListener(numberSender);
        }
        ctx.flush();
    }
}
