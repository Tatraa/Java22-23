package pl.edu.uj.textindexer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.uj.sender.SenderException;
import pl.edu.uj.textindexer.SenderResfulApplication;
import pl.edu.uj.textindexer.service.SenderService;
import pl.edu.uj.sender.*;

@RestController
public class SenderController {
    @Autowired
    SenderService sendService;

    @RequestMapping("/email")
    public @ResponseBody
    String sendEmail(@RequestParam(value = "address") String address,
                     @RequestParam(value = "title") String title,
                     @RequestParam(value = "message") String message)
                     throws SenderException, InterruptedException {
        try {
            sendService.sendEmail(address, title, message);
            return sendService.sendEmail(address, title, message);
        } catch (SenderException e) {
            return "Error " + e.getMessage();
        }
    }

    @RequestMapping("/push")
    public @ResponseBody
    String sendPush(@RequestParam(value = "address") String address,
                    @RequestParam(value = "title") String title,
                    @RequestParam(value = "message") String messege)
                    throws SenderException, InterruptedException {
        try {
            sendService.sendPush(address, title, messege);
            //return "Poszło, informacja w terminalu bo nie mam pojecia jak zrobic komunikat w url :)";
            return sendService.sendPush(address ,title, messege);
        } catch(SenderException e) {
            return "Error " + e.getMessage();
        }
    }
}
