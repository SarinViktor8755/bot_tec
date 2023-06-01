public class Tool {
    String pos; //Позиция	отм.
    String Name; //Наименование позиции
    String tip; //Тип датчика
    String nomber; // № прибора
    String scala;  //ШКАЛА
    String scala_tojnosty; // Класс точности
    String red_line; // Красная черта
    String date_proverky; //Год и квартал поверки или калибровки
    String interval; //Меж. поверочный интервал
    String group; // Группа
    String tip_proverky; // Тип проверки приборов

    public Tool(String pos, String name, String tip, String nomber, String scala, String scala_tojnosty, String red_line, String date_proverky, String interval, String group, String tip_proverky) {
        this.pos = pos;
        Name = name;
        this.tip = tip;
        this.nomber = nomber;
        this.scala = scala;
        this.scala_tojnosty = scala_tojnosty;
        this.red_line = red_line;
        this.date_proverky = date_proverky;
        this.interval = interval;
        this.group = group;
        this.tip_proverky = tip_proverky;
    }

    public Tool(String[] line) {
      //  System.out.println("--->>; "+line[0]);
        try {
            String[] tools = line[0].split(";");
            System.out.println(tools[0]);
            this.pos = tools[0];
            Name = tools[1];
            this.tip = tools[2];
            this.nomber = tools[3];
            this.scala = tools[4];
            this.scala_tojnosty = tools[5];
            this.red_line = tools[6];
            this.date_proverky = tools[7];
            this.interval = tools[8];
            this.group = tools[9];
            this.tip_proverky  = tools[10];
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }finally {
            System.out.println(this);
        }


       // System.out.println(this);
    }

    @Override
    public String toString() {
        return "Tool{" +
                "pos='" + pos + '\'' +
                ", Name='" + Name + '\'' +
                ", tip='" + tip + '\'' +
                ", nomber='" + nomber + '\'' +
                ", scala='" + scala + '\'' +
                ", scala_tojnosty='" + scala_tojnosty + '\'' +
                ", red_line='" + red_line + '\'' +
                ", date_proverky='" + date_proverky + '\'' +
                ", interval='" + interval + '\'' +
                ", group='" + group + '\'' +
                ", tip_proverky='" + tip_proverky + '\'' +
                '}';
    }
}
