package com.wristwatch.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.wristwatch.domain.UserRepository;
import com.wristwatch.service.UserService;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/reports")
public class ReportController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public void report() {

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Customer Id", "id", DataTypes.integerType()),
                        Columns.column("First Name", "firstname", DataTypes.stringType()),
                        Columns.column("Last Name", "lastname", DataTypes.stringType()))
                .title(//title of the report
                        Components.text("SimpleReportExample")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(userService.findAll());

        try {
            //show the report
            report.show();

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("main/resources/report.pdf"));
        }catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}