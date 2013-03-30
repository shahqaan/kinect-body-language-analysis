package shahqaan.kinect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/29/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
public class BodyPart {
    private BodyPartParameter forward = null, upward = null, openness = null, straight = null;

    /**
     *
     * @param forward
     * @param upward
     * @param openness
     * @param straight
     */
    public BodyPart(
            BodyPartParameter forward,
            BodyPartParameter upward,
            BodyPartParameter openness,
            BodyPartParameter straight) {
        this.forward = forward;
        this.upward = upward;
        this.openness = openness;
        this.straight = straight;
    }

    public BodyPart() {
    }

    public BodyPartParameter getForward() {
        return this.forward;
    }

    @XmlElement
    public void setForward(BodyPartParameter forward) {
        this.forward = forward;
    }

    public BodyPartParameter getUpward() {
        return this.upward;
    }

    @XmlElement
    public void setUpward(BodyPartParameter upward) {
        this.upward = upward;
    }

    public BodyPartParameter getOpenness() {
        return this.openness;
    }

    @XmlElement
    public void setOpenness(BodyPartParameter openness) {
        this.openness = openness;
    }

    public BodyPartParameter getStraight() {
        return this.straight;
    }

    @XmlElement
    public void setStraight(BodyPartParameter straight) {
        this.straight = straight;
    }
}
