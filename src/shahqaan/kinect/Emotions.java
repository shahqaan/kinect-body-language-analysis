package shahqaan.kinect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/30/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Emotions {
    private Emotion happy = null;
    private Emotion angry = null;

    public Emotion getHappy() {
        return happy;
    }

    @XmlElement
    public void setHappy(Emotion happy) {
        this.happy = happy;
    }

    public Emotion getAngry() {
        return angry;
    }

    @XmlElement
    public void setAngry(Emotion angry) {
        this.angry = angry;
    }
}
