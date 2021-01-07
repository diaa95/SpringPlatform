package com.diaa.ninjagold;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NinjaGoldController {
    @RequestMapping("/")
    public String start(HttpSession session){
        ArrayList<Log> log = new ArrayList<Log>();
        session.setAttribute("yourGold", 0);
        session.setAttribute("count", 0);
        session.setAttribute("log", log);

        return "redirect:/play";
    }

    @RequestMapping("/play")
    public String play(HttpSession session){
        if((Integer)session.getAttribute("yourGold") > -10){
            return "index.jsp";
        }
        else return "prison.jsp";
    }

    @RequestMapping(value = "/processMoney", method = RequestMethod.POST)
    public String processMoney(HttpSession session, @RequestParam(value = "which_form") String form) {
        int count = (Integer) session.getAttribute("count") + 1;
        session.setAttribute("count", count);
        Random rand = new Random();
        int gold = (Integer) session.getAttribute("yourGold");
        ArrayList<Log> list = (ArrayList) session.getAttribute("log");
        switch (form) {
            case "farm": {
                int num = rand.nextInt(10);
                num += 10;
                session.setAttribute("yourGold", gold + num);
                list.add(new Log(num, "farm"));
                return "redirect:/play";
            }
            case "cave": {
                int num = rand.nextInt(5);
                num += 5;
                session.setAttribute("yourGold", gold + num);
                list.add(new Log(num, "cave"));
                return "redirect:/play";
            }
            case "house": {
                int num = rand.nextInt(3);
                num += 2;
                session.setAttribute("yourGold", gold + num);
                list.add(new Log(num, "house"));
                return "redirect:/play";
            }
            case "casino": {
                int num = rand.nextInt(50);
                boolean b = rand.nextBoolean();
                if (!b) {
                    num = -num;
                }
                session.setAttribute("yourGold", gold + num);
                list.add(new Log(num, "casino"));
                return "redirect:/play";
            }
            default:
                return "redirect:/play";
        }
    }
}
