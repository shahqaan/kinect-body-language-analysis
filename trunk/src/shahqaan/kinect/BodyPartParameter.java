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
    private int span = 0;

    private boolean minSet = false;
    private boolean maxSet = false;

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
        this.span = max - min;
    }

    public BodyPartParameter() {
    }

    public int getMax() {
        return max;
    }

    @XmlElement
    public void setMax(int max) {
        this.max = max;
        this.maxSet = true;
        if (this.minSet) {
            this.span = this.max - this.min;
        }
    }

    public int getMin() {
        return min;

    }

    @XmlElement
    public void setMin(int min) {
        this.min = min;
        this.minSet = true;
        if (this.maxSet) {
            this.span = this.max - this.min;
        }
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        this.span = span;
    }
}
