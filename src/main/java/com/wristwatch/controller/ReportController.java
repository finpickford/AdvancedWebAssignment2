package com.wristwatch.controller;

import java.io.*;

import com.wristwatch.service.UserService;
import com.wristwatch.service.WatchbrandModelService;
import com.wristwatch.service.WatchbrandService;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/reports")
public class ReportController {
    @Autowired
    WatchbrandService watchbrandService;

    @Autowired
    WatchbrandModelService watchbrandModelService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createbrandreport", method = RequestMethod.GET)
    public String createBrandReport() {

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Brand Name", "brandname", DataTypes.stringType()))
                .title(//title of the report
                        Components.text("Brand Report")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(watchbrandService.findAll());

        try {

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("brandreport.pdf"));
        }catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/reports/viewbrandreport";
    }

    @RequestMapping(value = "/viewbrandreport", method = RequestMethod.GET)
    public void viewBrandReport(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = request.getServletContext();

        File report = new File("brandreport.pdf");
        FileInputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(report);

            response.setContentType(context.getMimeType("brandreport.pdf"));

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s", report.getName());
            response.setHeader(headerKey, headerValue);

            outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, outputStream);

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/createmodelreport", method = RequestMethod.GET)
    public String createModelReport() {

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Model Name", "modelname", DataTypes.stringType()),
                        Columns.column("Model Number", "modelno", DataTypes.stringType()),
                        Columns.column("Description", "description", DataTypes.stringType()),
                        Columns.column("Case Size", "casesize", DataTypes.stringType()),
                        Columns.column("Dial Colour", "dialcolour", DataTypes.stringType()),
                        Columns.column("Movement", "movement", DataTypes.stringType()),
                        Columns.column("Price", "price", DataTypes.stringType()))
                .title(//title of the report
                        Components.text("Brand Model Report")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(watchbrandModelService.findAll());

        try {

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("brandmodelreport.pdf"));
        }catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/reports/viewmodelreport";
    }

    @RequestMapping(value = "/viewmodelreport", method = RequestMethod.GET)
    public void viewModelReport(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = request.getServletContext();

        File report = new File("brandmodelreport.pdf");
        FileInputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(report);

            response.setContentType(context.getMimeType("brandmodelreport.pdf"));

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s", report.getName());
            response.setHeader(headerKey, headerValue);

            outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, outputStream);

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
    }

    @RequestMapping(value = "/createuserreport", method = RequestMethod.GET)
    public String createUserReport() {

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("First Name", "firstname", DataTypes.stringType()),
                        Columns.column("Last Name", "lastname", DataTypes.stringType()))
                .title(//title of the report
                        Components.text("User Report")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(userService.findAll());

        try {

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("userreport.pdf"));
        }catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/reports/viewuserreport";
    }

    @RequestMapping(value = "/viewuserreport", method = RequestMethod.GET)
    public void viewUserReport(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = request.getServletContext();

        File report = new File("userreport.pdf");
        FileInputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(report);

            response.setContentType(context.getMimeType("userreport.pdf"));

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s", report.getName());
            response.setHeader(headerKey, headerValue);

            outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, outputStream);

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/reportlinks", method = RequestMethod.GET)
    public String reportLinks(HttpSession session) {

        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        return "dashboard";


    }
}