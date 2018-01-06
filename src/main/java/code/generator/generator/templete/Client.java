package code.generator.generator.templete;

import code.generator.generator.common.util.FileUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception {

        String a = FileUtil.readFile2Str("templete/templete.templete", null);

        JAXBContext jc = JAXBContext.newInstance(CodeTemplete.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CodeTemplete c = (CodeTemplete) unmarshaller.unmarshal(new StringReader(a));
//        System.out.println(c.getFunctions());

        for(Function f : c.getFunctions()) {

            System.out.println(f.getFunctionBodys());
            for(FunctionBody fb : f.getFunctionBodys()) {

                System.out.println(fb.getBlankNum()+" ------> " + fb.getIndex() + " ------> " + fb.getValue());
            }
        }
    }

    public static void main1(String[] args) throws Exception {

        CodeTemplete codeTemplete = new CodeTemplete();

        codeTemplete.setClassName("InsUserDAOImpl");
        codeTemplete.setSuperName("IInsUserDAO");

        Constant constant1 = new Constant();
        constant1.setBlankNum(4);
        constant1.setIndex(1);
        constant1.setKey("UUID");
        constant1.setType("Long");
        constant1.setValue("12345678901234567890");

        Constant constant2 = new Constant();
        constant2.setBlankNum(4);
        constant2.setIndex(2);
        constant2.setKey("FIR_NAME");
        constant2.setType("String");
        constant2.setValue("first name");

        List<Constant> constants = new ArrayList<Constant>();
        constants.add(constant1);
        constants.add(constant2);
        codeTemplete.setConstants(constants);

        Field f1 = new Field();
        f1.setBlankNum(4);
        f1.setIndex(1);
        f1.setKey("billId");
        f1.setType("String");
        f1.setValue("18782972333");

        Field f2 = new Field();
        f2.setBlankNum(4);
        f2.setIndex(2);
        f2.setKey("custId");
        f2.setType("Long");
        f2.setValue("571009988");

        List<Field> fields = new ArrayList<Field>();
        fields.add(f1);
        fields.add(f2);
        codeTemplete.setFields(fields);


///////////
        Function function1 = new Function();
        function1.setBlankNum(4);
        function1.setIndex(1);
        function1.setName("Query");
        function1.setReturnType("InsUserBean");

        FunctionBody functionBody1 = new FunctionBody();
        functionBody1.setBlankNum(4);
        functionBody1.setIndex(1);
        functionBody1.setValue("String a = null;");

        FunctionBody functionBody2 = new FunctionBody();
        functionBody2.setBlankNum(4);
        functionBody2.setIndex(1);
        functionBody2.setValue("String a = null;");

        List<FunctionBody> functionBodies = new ArrayList<FunctionBody>();
        functionBodies.add(functionBody1);
        functionBodies.add(functionBody2);

        function1.setFunctionBodys(functionBodies);

        function1.setParamsTypes("String,Double");
//////////////////
        Function function2 = new Function();
        function2.setBlankNum(4);
        function2.setIndex(2);
        function2.setName("Insert");
        function2.setReturnType("InsUserBean");

        FunctionBody functionBody3 = new FunctionBody();
        functionBody3.setBlankNum(4);
        functionBody3.setIndex(1);
        functionBody3.setValue("String a = null;");

        FunctionBody functionBody4 = new FunctionBody();
        functionBody4.setBlankNum(4);
        functionBody4.setIndex(1);
        functionBody4.setValue("String a = null;");

        List<FunctionBody> functionBodies1 = new ArrayList<FunctionBody>();
        functionBodies1.add(functionBody3);
        functionBodies1.add(functionBody4);

        function2.setFunctionBodys(functionBodies1);

        function2.setParamsTypes("String,Double,Long");


        List<Function> functions = new ArrayList<Function>();
        functions.add(function1);
        functions.add(function2);

        codeTemplete.setFunctions(functions);




        JAXBContext jc = JAXBContext.newInstance(CodeTemplete.class);
        Marshaller m = jc.createMarshaller();
        m.marshal(codeTemplete,System.out);
    }
}
