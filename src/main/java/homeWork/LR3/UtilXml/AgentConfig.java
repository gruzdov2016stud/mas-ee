package homeWork.LR3.UtilXml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "nodeAgent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentConfig {
    @XmlElementWrapper(name = "neighborsNodes")
    @XmlElement(name = "nodes")
    private ArrayList<DataNodeConfig> dataNodes;

    @XmlElement(name = "start")
    private boolean start;
    @XmlElement(name = "end")
    private boolean end;

    public ArrayList<DataNodeConfig> getDataNodes() {
        return dataNodes;
    }

    public void setDataNodes(ArrayList<DataNodeConfig> dataNodes) {
        this.dataNodes = dataNodes;
    }


    public boolean getStart() {
        return start;
    }
    public void setStart(boolean start) {
        this.start = start;
    }
    public boolean getEnd() {
        return end;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
}

