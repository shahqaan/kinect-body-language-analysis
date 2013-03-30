package shahqaan.kinect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/30/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Parts {

    private BodyPart head = null;
    private BodyPart shoulders = null;
    private BodyPart chest = null;
    private BodyPart knees = null;
    private BodyPart arms = null;

    public BodyPart getHead() {
        return head;
    }

    @XmlElement
    public void setHead(BodyPart head) {
        this.head = head;
    }

    public BodyPart getShoulders() {
        return shoulders;
    }

    @XmlElement
    public void setShoulders(BodyPart shoulders) {
        this.shoulders = shoulders;
    }

    public BodyPart getChest() {
        return chest;
    }

    @XmlElement
    public void setChest(BodyPart chest) {
        this.chest = chest;
    }

    public BodyPart getKnees() {
        return knees;
    }

    @XmlElement
    public void setKnees(BodyPart knees) {
        this.knees = knees;
    }

    public BodyPart getArms() {
        return arms;
    }

    @XmlElement
    public void setArms(BodyPart arms) {
        this.arms = arms;
    }
}
