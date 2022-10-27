package classWork.pr1.connector;


import classWork.pr1.model.DataClass;

public class ModbusConnector extends Connector{
    @Override
    public boolean sendData(DataClass data) {
        System.out.println("Data successfully sent by modbus module");
        return true;
    }
}
