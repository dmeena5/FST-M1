from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/drag-drop")
    print("The title is: ", driver.title)
    #Find the ball and simulate a click and drag to move it into "Dropzone 1".
    #Verify that the ball has entered Dropzone 1.
    #Once verified, move the ball into "Dropzone 2".
    #Verify that the ball has entered Dropzone 2.
    actions = ActionChains(driver)
    ball = driver.find_element(By.ID, "draggable")
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")
    actions.drag_and_drop(ball, dropzone1).perform()
    if(dropzone1.text.find("Dropped!")):
        print("The ball is in Dropzone 1")
    actions.drag_and_drop(dropzone1, dropzone2).perform()
    if(dropzone2.text.find("Dropped!")):
        print("The ball is in Dropzone 2")



