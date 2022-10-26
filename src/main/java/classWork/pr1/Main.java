package classWork.pr1;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Connector modbus = new ModbusConnector();
//        Connector iec104 = new Iec104Connector();
//
//        List<Connector> connectorList = List.of(modbus, iec104);
//
//        DataClass d = new DataClass("data");
//        connectorList.forEach(el -> el.sendData(d));
//
//        List<String> col = new ArrayList<>();
//        List<String> col2 = new ArrayList<>();
//        List<String> col3 = new LinkedList<>();
//        List<String> col4 = new CopyOnWriteArrayList<>();
//        //...
//        print(col4);
//        Writer fileW = new FileWriter();
//        fileW.configure(Collections.singletonList("log.txt"));
//        fileW.execute("hello world");
//
//        Writer consoleW = new ConsoleWriter();
//        consoleW.configure(Collections.singletonList("Out"));
//        consoleW.execute("hellow world!!!");
//
//        List<Writer> impls = new ArrayList<>();
//        impls.add(fileW);
//        impls.add(consoleW);
//
//        //...
//        ConnectorType t = ConnectorType.Console;
//        String msg ="dasdas";
//
//        impls.stream().filter(el -> el.getType() == t).findAny().get().execute(msg);

//        for (Writer impl : impls) {
//            if (impl.getType() == t){
//                impl.execute(msg);
//            }
//        }



    }

    public static void print(List<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }
}
