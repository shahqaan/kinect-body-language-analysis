package shahqaan.kinect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/30/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Emotion {
    private Parts parts = null;

    public Parts getParts() {
        return parts;
    }

    @XmlElement
    public void setParts(Parts parts) {
        this.parts = parts;
    }
}
