package homeWork.LR3.UtilXml;

import java.util.ArrayList;

public class XmlObject {
    public static void main(String[] args) {

        // todo FirstAgent
        AgentConfig Node1 = new AgentConfig();
        Node1.setStart(true);
        Node1.setEnd(false);
        DataNodeConfig Node112 = new DataNodeConfig("Node2",7);
        DataNodeConfig Node13 = new DataNodeConfig("Node3",24);
        DataNodeConfig Node14 = new DataNodeConfig("Node4",14);
        DataNodeConfig Node15 = new DataNodeConfig("Node5",16);

        ArrayList<DataNodeConfig> firstListAgent = new ArrayList<>();
        firstListAgent.add(Node112);
        firstListAgent.add(Node13);
        firstListAgent.add(Node14);
        firstListAgent.add(Node15);
        Node1.setDataNodes(firstListAgent);
        XmlHelper.marshalAny(Node1,"Node1.xml" );

        // todo ItermediaAgent
        AgentConfig Node2 = new AgentConfig();
        Node2.setStart(false);
        Node2.setEnd(false);
        DataNodeConfig Node21 = new DataNodeConfig("Node1",7);
        DataNodeConfig Node23 = new DataNodeConfig("Node3",17);
        DataNodeConfig Node24 = new DataNodeConfig("Node4",20);
        DataNodeConfig Node25 = new DataNodeConfig("Node5",25);

        ArrayList<DataNodeConfig> twoListAgent = new ArrayList<>();
        twoListAgent.add(Node21);
        twoListAgent.add(Node23);
        twoListAgent.add(Node24);
        twoListAgent.add(Node25);
        Node2.setDataNodes(twoListAgent);
        XmlHelper.marshalAny(Node2,"Node2.xml" );

        AgentConfig Node3 = new AgentConfig();
        Node3.setStart(false);
        Node3.setEnd(false);
        DataNodeConfig Node31 = new DataNodeConfig("Node1",24);
        DataNodeConfig Node32 = new DataNodeConfig("Node2",17);
        DataNodeConfig Node34 = new DataNodeConfig("Node4",15);
        DataNodeConfig Node35 = new DataNodeConfig("Node5",2);

        ArrayList<DataNodeConfig> threeListAgent = new ArrayList<>();
        threeListAgent.add(Node31);
        threeListAgent.add(Node32);
        threeListAgent.add(Node34);
        threeListAgent.add(Node35);
        Node3.setDataNodes(threeListAgent);
        XmlHelper.marshalAny(Node3,"Node3.xml" );


        AgentConfig Node4 = new AgentConfig();
        Node4.setStart(false);
        Node4.setEnd(false);
        DataNodeConfig Node41 = new DataNodeConfig("Node1",14);
        DataNodeConfig Node42 = new DataNodeConfig("Node2",20);
        DataNodeConfig Node43 = new DataNodeConfig("Node3",15);
        DataNodeConfig Node45 = new DataNodeConfig("Node5",11);
        DataNodeConfig Node46 = new DataNodeConfig("Node6",23);
        DataNodeConfig Node47 = new DataNodeConfig("Node7",11);
        DataNodeConfig Node48 = new DataNodeConfig("Node8",17);

        ArrayList<DataNodeConfig> fourListAgent = new ArrayList<>();
        fourListAgent.add(Node41);
        fourListAgent.add(Node42);
        fourListAgent.add(Node43);
        fourListAgent.add(Node45);
        fourListAgent.add(Node46);
        fourListAgent.add(Node47);
        fourListAgent.add(Node48);
        Node4.setDataNodes(fourListAgent);
        XmlHelper.marshalAny(Node4,"Node4.xml" );

        AgentConfig Node5 = new AgentConfig();
        Node5.setStart(false);
        Node5.setEnd(false);
        DataNodeConfig Node51 = new DataNodeConfig("Node1",16);
        DataNodeConfig Node52 = new DataNodeConfig("Node2",25);
        DataNodeConfig Node53 = new DataNodeConfig("Node3",2);
        DataNodeConfig Node54 = new DataNodeConfig("Node4",11);
        DataNodeConfig Node56 = new DataNodeConfig("Node6",23);
        DataNodeConfig Node57 = new DataNodeConfig("Node7",15);
        DataNodeConfig Node58 = new DataNodeConfig("Node8",6);

        ArrayList<DataNodeConfig> Node5ListAgent = new ArrayList<>();
        Node5ListAgent.add(Node51);
        Node5ListAgent.add(Node52);
        Node5ListAgent.add(Node53);
        Node5ListAgent.add(Node54);
        Node5ListAgent.add(Node56);
        Node5ListAgent.add(Node57);
        Node5ListAgent.add(Node58);
        Node5.setDataNodes(Node5ListAgent);
        XmlHelper.marshalAny(Node5,"Node5.xml" );

        AgentConfig Node6 = new AgentConfig();
        Node6.setStart(false);
        Node6.setEnd(false);
        DataNodeConfig Node64 = new DataNodeConfig("Node4",23);
        DataNodeConfig Node65 = new DataNodeConfig("Node5",23);
        DataNodeConfig Node67 = new DataNodeConfig("Node7",14);
        DataNodeConfig Node68 = new DataNodeConfig("Node8",6);
        DataNodeConfig Node69 = new DataNodeConfig("Node9",20);

        ArrayList<DataNodeConfig> Node6ListAgent = new ArrayList<>();
        Node6ListAgent.add(Node64);
        Node6ListAgent.add(Node65);
        Node6ListAgent.add(Node67);
        Node6ListAgent.add(Node68);
        Node6ListAgent.add(Node69);
        Node6.setDataNodes(Node6ListAgent);
        XmlHelper.marshalAny(Node6,"Node6.xml" );


        AgentConfig Node7 = new AgentConfig();
        Node7.setStart(false);
        Node7.setEnd(false);
        DataNodeConfig Node74 = new DataNodeConfig("Node4",11);
        DataNodeConfig Node75 = new DataNodeConfig("Node5",15);
        DataNodeConfig Node76 = new DataNodeConfig("Node6",14);
        DataNodeConfig Node78 = new DataNodeConfig("Node8",14);
        DataNodeConfig Node79 = new DataNodeConfig("Node9",9);

        ArrayList<DataNodeConfig> Node7ListAgent = new ArrayList<>();
        Node7ListAgent.add(Node74);
        Node7ListAgent.add(Node75);
        Node7ListAgent.add(Node76);
        Node7ListAgent.add(Node78);
        Node7ListAgent.add(Node79);
        Node7.setDataNodes(Node7ListAgent);
        XmlHelper.marshalAny(Node7,"Node7.xml" );

        AgentConfig Node8 = new AgentConfig();
        Node8.setStart(false);
        Node8.setEnd(false);
        DataNodeConfig Node84 = new DataNodeConfig("Node4",17);
        DataNodeConfig Node85 = new DataNodeConfig("Node5",6);
        DataNodeConfig Node86 = new DataNodeConfig("Node6",6);
        DataNodeConfig Node87 = new DataNodeConfig("Node7",14);
        DataNodeConfig Node89 = new DataNodeConfig("Node9",17);

        ArrayList<DataNodeConfig> Node8ListAgent = new ArrayList<>();
        Node8ListAgent.add(Node84);
        Node8ListAgent.add(Node85);
        Node8ListAgent.add(Node86);
        Node8ListAgent.add(Node87);
        Node8ListAgent.add(Node89);
        Node8.setDataNodes(Node8ListAgent);
        XmlHelper.marshalAny(Node8,"Node8.xml" );

        AgentConfig Node9 = new AgentConfig();
        Node9.setStart(false);
        Node9.setEnd(false);
        DataNodeConfig Node96 = new DataNodeConfig("Node6",20);
        DataNodeConfig Node97 = new DataNodeConfig("Node7",9);
        DataNodeConfig Node98 = new DataNodeConfig("Node9",17);
        DataNodeConfig Node910 = new DataNodeConfig("Node10",25);
        DataNodeConfig Node911 = new DataNodeConfig("Node11",6);
        DataNodeConfig Node912 = new DataNodeConfig("Node12",25);

        ArrayList<DataNodeConfig> Node9ListAgent = new ArrayList<>();
        Node9ListAgent.add(Node96);
        Node9ListAgent.add(Node97);
        Node9ListAgent.add(Node98);
        Node9ListAgent.add(Node910);
        Node9ListAgent.add(Node911);
        Node9ListAgent.add(Node912);
        Node9.setDataNodes(Node9ListAgent);
        XmlHelper.marshalAny(Node9,"Node9.xml" );

        AgentConfig Node10 = new AgentConfig();
        Node10.setStart(false);
        Node10.setEnd(false);
        DataNodeConfig Node109 = new DataNodeConfig("Node9",25);
        DataNodeConfig Node1011 = new DataNodeConfig("Node11",6);
        DataNodeConfig Node1012 = new DataNodeConfig("Node12",1);

        ArrayList<DataNodeConfig> Node10ListAgent = new ArrayList<>();
        Node10ListAgent.add(Node109);
        Node10ListAgent.add(Node1011);
        Node10ListAgent.add(Node1012);
        Node10.setDataNodes(Node10ListAgent);
        XmlHelper.marshalAny(Node10,"Node10.xml" );

        AgentConfig Node11 = new AgentConfig();
        Node11.setStart(false);
        Node11.setEnd(false);
        DataNodeConfig Node119 = new DataNodeConfig("Node9",6);
        DataNodeConfig Node1110 = new DataNodeConfig("Node10",6);
        DataNodeConfig Node1112 = new DataNodeConfig("Node12",20);

        ArrayList<DataNodeConfig> Node11ListAgent = new ArrayList<>();
        Node11ListAgent.add(Node119);
        Node11ListAgent.add(Node1110);
        Node11ListAgent.add(Node1112);
        Node11.setDataNodes(Node11ListAgent);
        XmlHelper.marshalAny(Node11,"Node11.xml" );


        // todo LastAgent
        AgentConfig Node12 = new AgentConfig();
        Node12.setStart(false);
        Node12.setEnd(true);
        DataNodeConfig Node129 = new DataNodeConfig("Node9",25);
        DataNodeConfig Node1210 = new DataNodeConfig("Node10",1);
        DataNodeConfig Node1212 = new DataNodeConfig("Node12",20);

        ArrayList<DataNodeConfig> Node12ListAgent = new ArrayList<>();
        Node12ListAgent.add(Node129);
        Node12ListAgent.add(Node1210);
        Node12ListAgent.add(Node1212);
        Node12.setDataNodes(Node12ListAgent);
        XmlHelper.marshalAny(Node12,"Node12.xml" );

    }


}
