from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/tab-opener")
    print("Page title is: ", driver.title)
    print("Current window handle: ", driver.current_window_handle)
    #Find the button to open a new tab and click it.
    driver.find_element(By.ID,"launcher").click()
    #Wait for the new tab to open.
    wait = WebDriverWait(driver,10)
    wait.until(EC.number_of_windows_to_be(2))
    #Print all the handles.
    print("All window handles available are: ", driver.window_handles)
    #Switch to the newly opened tab, print it's title and heading.
    driver.switch_to.window(driver.window_handles[1])
    print("The current handle is: ", driver.current_window_handle)
    print("The heading of the page is: ", driver.title)
    #Repeat the steps by clicking the button in the new tab page.
    wait.until(EC.visibility_of_element_located((By.ID,"actionButton")))
    driver.find_element(By.ID,"actionButton").click()
    wait.until(EC.number_of_windows_to_be(3))
    #Print all the handles.
    print("All window handles available are: ", driver.window_handles)
    #Switch to the newly opened tab, print it's title and heading.
    driver.switch_to.window(driver.window_handles[2])
    print("The current handle is: ", driver.current_window_handle)
    print("The heading of the page is: ", driver.title)
