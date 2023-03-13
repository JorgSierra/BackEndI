const { Builder, Capabilities, By, Key} = require("selenium-webdriver");
const chromeCapabilities = Capabilities.chrome();

const assert = require('assert');

async function Booking(){
    chromeCapabilities.set('chromeOptions', {arg:['--headless']});
    let driver = await new Builder().forBrowser('chrome').withCapabilities(chromeCapabilities).build();
    
    await driver.get('http://fe.deitech.online/');
    await driver.manage().window().maximize();
    await driver.sleep(2000);



}
Booking();
