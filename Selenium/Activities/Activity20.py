from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.remote.webdriver import By

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/javascript-alerts")
    print("Page title is: ", driver.title)
    #Find the button to open a CONFIRM alert and click it.
    driver.find_element(By.ID, "prompt").click()
    #Switch the focus from the main window to the Alert box and get the text in it and print it.
    prompt_alert = driver.switch_to.alert
    print(prompt_alert.text)
    #Close the alert once with Ok and again with Cancel.
    prompt_alert.send_keys("Awesome!")
    prompt_alert.accept()
    print("The alert is accepted")
    driver.find_element(By.ID, "prompt").click()
    prompt_alert1 = driver.switch_to.alert
    print(prompt_alert1.text)
    prompt_alert1.dismiss()
    print("The alert is dismissed")