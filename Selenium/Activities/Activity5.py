from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as Firefoxservice
from selenium.webdriver.support.select import Select
from selenium.webdriver.common.by import By

service = Firefoxservice(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/input-events")
    print("The title of the page is:", driver.title)
    actions = webdriver.ActionChains(driver)
    #Left click and print the value of the side in the front.
    actions.click().perform()
    leftClick = driver.find_element(By.CLASS_NAME, "active")
    print("The value on left click is: ", leftClick.text)
    #Double click to show a random side and print the number.
    actions.double_click().perform()
    doubleClick = driver.find_element(By.CLASS_NAME,"active")
    print("The value seen on random side is: ", doubleClick.text)
    #Right click and print the value shown on the front of the cube.
    actions.context_click().perform()
    rightClick = driver.find_element(By.CLASS_NAME,"active")
    print("The value after the right click is: ", rightClick.text)

    driver.quit()
