import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.ArrayList;


public class Main {




    public static void main(String[] args) {
//        // Initialize Api Context
//        ApiContextInitializer.init();
//        // Instantiate Telegram Bots API
//        TelegramBotsApi botsApi = new TelegramBotsApi();
        ArrayList<Tool> tools = new ArrayList<>();
        // new CsvBD(tools);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            BotSession bs = null;
            try {
                bs = telegramBotsApi.registerBot(new BotTelega(args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(bs.isRunning());
            System.out.println("registerBot");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




}
