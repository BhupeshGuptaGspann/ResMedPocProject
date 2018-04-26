Feature: ResMed login

Background:

Given User launched ResMed Application
Then verify ResApp login page is opened

Scenario: ResMed Login Test Scenario

When login to ResMed application
Then verify title of the landing page
Then logout from ResMed Application

