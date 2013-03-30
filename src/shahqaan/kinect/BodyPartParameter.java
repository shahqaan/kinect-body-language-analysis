package shahqaan.kinect;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Shahqaan Qasim
 * Date: 3/29/13
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */


@XmlRootElement
public class BodyPartParameter {
    private int min = 0, max = 0;

    /**
     *
     * @param min
     *  min value of the parameter
     * @param max
     *  max value of the parameter
     */
    public BodyPartParameter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public BodyPartParameter() {
    }

    public int getMax() {
        return max;
    }

    @XmlElement
    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;

    }

    @XmlElement
    public void setMin(int min) {
        this.min = min;
    }
}
