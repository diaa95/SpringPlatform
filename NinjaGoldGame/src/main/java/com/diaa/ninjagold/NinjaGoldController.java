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
        return "index.jsp";
    }

    @RequestMapping(value = "/processMoney", method = RequestMethod.POST)
    public String processMoney(HttpSession session, @RequestParam(value = "which_form") String form) {
        int count = (Integer) session.getAttribute("count") + 1;
        session.setAttribute("count", count);
        Random rand = new Random();
        if (form.equals("farm")) {
            int num = rand.nextInt(10);
            num += 10;
            int gold = (Integer) session.getAttribute("yourGold");
            session.setAttribute("yourGold", gold + num);
            ArrayList<Log> list = (ArrayList) session.getAttribute("log");
            list.add(new Log(num, "farm"));
            return "redirect:/play";
        }else if (form.equals("casino")) {
            int num = rand.nextInt(50);
            boolean b = rand.nextBoolean();
            if (!b){
                num = -1 * num;
            }
            int gold = (Integer) session.getAttribute("yourGold");
            session.setAttribute("yourGold", gold + num);
            ArrayList<Log> list = (ArrayList) session.getAttribute("log");
            list.add(new Log(num, "casino"));
            return "redirect:/play";
        } else {
            return "redirect:/play";
        }
    }
}
