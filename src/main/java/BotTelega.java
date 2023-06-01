import Anser.Test;
import Anser.modelQuestion;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BotTelega extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;
    SendMessage mes;
    Test t;



    String[] tempSplit;

    final String scream = EmojiParser.parseToUnicode(":scream:");
    final String pushpin = EmojiParser.parseToUnicode(":pushpin:");
    final String point_right = EmojiParser.parseToUnicode(":point_right:");
    final String question = EmojiParser.parseToUnicode(":question:");


    private HashMap<String, Boolean> usersFormat;


    public BotTelega(String url) throws IOException {
        super();
        t = new Test(url);
        this.BOT_NAME = "instrumentationtetris_";
        this.BOT_TOKEN = "5501647244:AAF9WO-yXJ4s2sbgn7ZRc4yYNOU39t_yQ6E";
        mes = new SendMessage();
        usersFormat = new HashMap<>();
        //создаём вспомогательный класс для работы с сообщениями, не являющимися командами
        //   this.nonCommand = new NonCommand();

    }


    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }


    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("!!!");
//        // We check if the update has a message and the message has text
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            // Set variables
//            String message_text = update.getMessage().getText();
//            long chat_id = update.getMessage().getChatId();
//
//            System.out.println(update.getMessage().getText());
//
////            SendMessage message = /(chat_id).setText(message_text);
////            try {
////                execute(message); // Sending our message object to user
////            } catch (TelegramApiException e) {
////                e.printStackTrace();
////            }
//        }

    }

    private void printAnswer(String text, StringBuilder sb) {
        tempSplit = text.split("nl");
//        System.out.println(text);
//        System.out.println(tempSplit.length);

        for (int i = 0; i < tempSplit.length; i++) {
            sb.append("iii!!");
        }
//
//        for (int i = 0; i < tempSplit.length; i++) {
//            sb.append("\n" + point_right + " " + tempSplit[i].trim());
//        }
        sb.append(" \n  \n ");
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        String hashnAME = updates.get(0).getMessage().getFrom().getId() + updates.get(0).getMessage().getFrom().getFirstName() + updates.get(0).getMessage().getFrom().getUserName();
        System.out.println(hashnAME +" >>>> " + updates.get(0).getMessage().getText()+" >>>> " );
        String text = updates.get(0).getMessage().getText();
        mes.setChatId(String.valueOf(updates.get(0).getMessage().getChatId()));

        if (text.equals("/format")) {
            changUser(hashnAME);
            if (getUserFormat(hashnAME))
                mes.setText(pushpin + " Формат вопроса ВКЛЮЧЕН");
            else mes.setText(pushpin + " Формат вопроса Выкл");
            try {
                execute(mes); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (text.equals("/all_questions")) {
            for (int i = 0; i < t.getQuestions().size(); i++) {
                try {
                    mes.setText(i + " " + t.getQuestions().get(i).getQuestion() + question + " \n " + point_right);
                    //mes.setText(t.get(i).getQuestion(), formatTe) + " \n " + point_right + " " + ot.get(i).getAnswer() + " \n " + " \n ");
                    printAnswer(t.getQuestions().get(i).getAnswer(), sb);
                    execute(mes); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            return;
        }

        if (text.equals("/start")) {

                try {
                    mes.setText("https://cs2.pikabu.ru/post_img2/big/2014/02/04/6/1391502434_1778478879.jpg");
                    mes.setDisableNotification(true);
                    mes.setAllowSendingWithoutReply(true);

                    execute(mes); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            return;
        }

        if (text.equals("/r")) {
                this.t.restartFileReader();
            try {
                mes.setText(scream + scream + scream +" перезагружен");
                execute(mes); // Sending our message object to user

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }finally {
                return;
            }
        }


        ArrayList<modelQuestion> ot = t.fine(text);

        boolean formatTe = !getUserFormat(hashnAME);
        int y = 0;

//        for (int i = 0; i < 2222; i++) {
//
//            sb.append("- "+i);
////            sb.append(question + " " + filterOthrer(ot.get(i).getQuestion(), formatTe));
//            printAnswer(ot.get(i).getAnswer(), sb);
//            y++;
//        }

        try {
            System.out.println(text + "  !!!!!");
            for (String element : CsvBD.list_enty) {
//                System.out.println();
//                System.out.println(element);

                //string.contains(substring)
                if(element.contains(text)) {mes.setText(element);
                execute(mes); // Sending our message object to user
                     }
            }
            mes.setText(point_right + scream + scream + point_right);
            execute(mes);
         //   "111111111111111111111111111111111111" + mes);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


//        if (sb.length() < 1) sb.append(scream + " Нет совпадений");
//        if (sb.length() > 4_000) {
//            try {
//                mes.setText(scream + " ответ слишком большой");
//                execute(mes); // Sending our message object to user
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//            return;
//        }

        mes.setText(sb.toString());
        try {
            execute(mes); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("<<<< " + y);
    }

    private String filterOthrer(String t, boolean format) {
        if (format) return t;
        if (t.length() > 45)
            return t.substring(0, 45) + "...";
        else return t;
    }

    private boolean getUserFormat(String hashUser) {
        if (usersFormat.get(hashUser) == null) {
            usersFormat.put(hashUser, true);
        }
        return usersFormat.get(hashUser);
    }

    private void changUser(String hashUser) {
        if (usersFormat.get(hashUser) == null) {
            usersFormat.put(hashUser, true);
        } else {
            if (usersFormat.get(hashUser)) usersFormat.put(hashUser, false);
            else usersFormat.put(hashUser, true);
        }


        //System.out.println(usersFormat);
    }

    private void senMess(String mess) {

    }

}
