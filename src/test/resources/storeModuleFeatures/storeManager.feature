@StoreManagerTest
  Feature: Store Manager

    Background:
      Given manager is on Login page
      When manager enter username and password then click on login button
      Then manager successfully login to the dashboard page