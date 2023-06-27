from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains


service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/input-events")
    print("The title of the page is: ", driver.title)
    #Press the key of first letter of your name in caps
    #Press CTRL+a and the CTRL+c to copy all the text on the page.
    actions = ActionChains(driver)
    actions.send_keys("M").key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()
    