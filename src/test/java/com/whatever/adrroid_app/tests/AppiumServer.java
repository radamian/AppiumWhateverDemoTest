package com.whatever.adrroid_app.tests;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppiumServer {
    public AppiumDriverLocalService appiumService;
    public String appiumServiceUrl;

    AppiumDriverLocalService service;
    DesiredCapabilities cap;

    public void startServer() {

//Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.NO_RESET, false);


//Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);

        builder.withCapabilities(cap);

        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");

//Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("***Start appium service***");
    }

    public void stopServer() {
        service.stop();
        System.out.println("***Stop appium service***");
    }


}
