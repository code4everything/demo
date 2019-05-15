package org.code4everything.demo.lombok;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author pantao
 * @since 2019/5/15
 **/
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
// @Value(staticConstructor = "of")
@RequiredArgsConstructor(onConstructor_ = {@NonNull})
class LombokData implements Serializable {

    private static final long serialVersionUID = -4680696090848109062L;

    @NonNull
    private Date date;

    private String weather;

    private String mood;

    @Singular("city")
    private List<String> cities;

    public static void main(String[] args) {
        // test constructor
        LombokData data = new LombokData(new Date());

        // test getter and setting
        String weatcher = "wind";
        data.setWeather(weatcher);
        assert weatcher.equals(data.getWeather());

        // test to string
        System.out.println(data.setMood("nice"));

        // test builder
        data = new LombokDataBuilder().date(new Date()).mood("curious").weather("sunny").city("chengdu").build();
        System.out.println(data);

        // test non null, this will throw a null pointer exception
        data.setDate(null);
    }

    @Generated
    @Synchronized
    LombokData setMood(String mood) {
        this.mood = mood;
        return this;
    }
}
