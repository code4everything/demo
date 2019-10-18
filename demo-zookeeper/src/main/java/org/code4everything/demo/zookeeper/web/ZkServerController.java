package org.code4everything.demo.zookeeper.web;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author pantao
 * @since 2019/10/18
 */
@RestController
@RequestMapping("/zk")
public class ZkServerController {

    private ZkClient clientOne;

    private ZkClient clientTwo;

    @PostConstruct
    public void init() {
        startOne();
        startTwo();
    }

    @RequestMapping("/one/write/{data}")
    public void writeDataForOne(@PathVariable String data) {
        clientOne.writeData("/zk/one", data);
    }

    @RequestMapping("/two/write/{data}")
    public void writeDataForTwo(@PathVariable String data) {
        clientTwo.writeData("/zk/two", data);
    }

    @RequestMapping("/one/close")
    public void closeOne() {
        clientOne.close();
    }

    @RequestMapping("/two/close")
    public void closeTwo() {
        clientTwo.close();
    }

    @RequestMapping("one/start")
    public void startOne() {
        clientOne = new ZkClient("localserver:2181");
        String pathOne = "/zk/one";
        if (!clientOne.exists(pathOne)) {
            // clientOne.createPersistent(pathOne, true);
            clientOne.createEphemeral(pathOne);
        }
    }

    @RequestMapping("two/start")
    public void startTwo() {
        clientTwo = new ZkClient("localserver:2181");
        String pathTwo = "/zk/two";
        if (!clientTwo.exists(pathTwo)) {
            // clientTwo.createPersistent(pathTwo, true);
            clientTwo.createEphemeral(pathTwo);
        }
    }
}
