# Menu checking
#Goal: Make sure that the “Activities” menu item exists and is clickable

from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.remote.webdriver import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/crm/")
    print("Home Page Title is: " + driver.title)
    # Menu checking
    #Goal: Make sure that the “Activities” menu item exists and is clickable
    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//*[@id=\"bigbutton\"]").click()
    navigationMenu = driver.find_element(By.ID,"toolbar").get_attribute("id")
    print("The user is on the home page with the Navigation Menu")
    ActivitiesItem = driver.find_element(By.ID,"grouptab_3").get_attribute("id")
    assert ActivitiesItem == "grouptab_3"
    print("The item 'Activities' exists in the Menu")