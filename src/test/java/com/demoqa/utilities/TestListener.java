package com.demoqa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
 ExtentSparkReporter sparkReporter;
 ExtentReports extent;
 ExtentTest test;
 
 @Override
 public void onStart(ITestContext context) {
 sparkReporter = new ExtentSparkReporter("ExtentReport.html");
 extent = new ExtentReports();
 extent.attachReporter(sparkReporter);
 }
 @Override
 public void onTestStart(ITestResult result) {
 test = extent.createTest(result.getName());
 }
 @Override
 public void onTestSuccess(ITestResult result) {
 test.pass("Test Passed: " + result.getName());
 }
 @Override
 public void onTestFailure(ITestResult result) {
 test.fail("Test Failed: " + result.getName());
 }
 @Override
 public void onTestSkipped(ITestResult result) {
 test.skip("Test Skipped: " + result.getName());
 }
 
 @Override
 public void onFinish(ITestContext context) {
 extent.flush();
 }
}