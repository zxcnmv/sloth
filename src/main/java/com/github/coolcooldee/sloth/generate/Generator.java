package com.github.coolcooldee.sloth.generate;

import com.github.coolcooldee.sloth.parameter.*;

import com.github.coolcooldee.sloth.utils.DirectoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generator {

    static Logger logger = LoggerFactory.getLogger(Generator.class);

    public static void execute(String[] args) throws Exception{

        // Step 1
        UserInputParamters.init(args);
        // Step 2
        DBSourceParameters.inti();
        // Step 3
        TargetProjectParameters.init();
        // Step 4
        TemplateParameters.init();
        // Step 5
        GeneratorSteategyParameters.init();
        // Step 6
        GeneratorSteategyParameters.getGeneratorStrategy().execute();
        //Step 7
        printlnResult();
    }

    private static void printlnResult(){
        logger.info("\nTarget project directory is : " + TargetProjectParameters.getTargetProjectStorePath());
        DirectoryUtil.readFile(TargetProjectParameters.getTargetProjectStorePath());
        logger.info("\n\n");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        logger.info("@      Genarate Successfully !       @");
        logger.info("@   Thank you for using Sloth 1.0    @");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    public static void main(String[] args) throws Exception {
        Generator.execute(args);
    }

}
