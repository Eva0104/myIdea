package com.zhuxiaoxue.web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/captcha.png")
public class CaptchaServlet extends HttpServlet {

    private Logger logger =  LoggerFactory.getLogger(CaptchaServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory((new SingleColorFactory(new Color(48, 58, 170))));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

        OutputStream outputStream = resp.getOutputStream();
        String captcha = EncoderHelper.getChallangeAndWriteImage(cs, "png", outputStream);

//        RandomWordFactory factory = new RandomWordFactory();
//        factory.setMinLength(4); factory.setMaxLength(4);
//        factory.setCharacters("1234567890");
//        cs.setWordFactory(factory);

        HttpSession session = req.getSession();
        session.setAttribute("captcha",captcha);

        logger.info("captcha:{}",captcha);

        outputStream.flush();
        outputStream.close();

    }
}
