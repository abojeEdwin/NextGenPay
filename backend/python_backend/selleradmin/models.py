from enum import Enum

from django.db import models
from User.admin import SellerAdmin
# Create your models here.

# class SellerAdmin()
class Cashier(models.Model):
    cashier_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=11)
    last_name = models.CharField(max_length=255)
    user_name = models.CharField(max_length=11, unique=True)
    email = models.EmailField(unique=True)
    dob = models.DateField(blank=False, null=False)
    profile_pic = models.ImageField(blank=False, upload_to="profile_pics/")

class Business_type(Enum):
    STARTER = "starter" ,
    REGISTERED = "registered" ,

class Bank_Account(models.Model):
    bank_account_id = models.AutoField(primary_key=True)
    bank_name = models.CharField(max_length=11)
    bank_account_number = models.CharField(max_length=10)
    account_name = models.CharField(max_length=11)

class SellerAdminProfile(models.Model):
    profile_id = models.AutoField(primary_key=True)
    seller_id = models.ForeignKey(SellerAdmin, on_delete=models.CASCADE)
    first_name = models.CharField(max_length=11)
    last_name = models.CharField(max_length=25)
    user_name = models.CharField(max_length=11)
    address = models.CharField(max_length=50)
    business_name = models.CharField(max_length=11)
    business_type = Business_type.STARTER
    bank_account_id = models.ForeignKey(Bank_Account, on_delete=models.CASCADE)
    dob = models.DateField(blank=False, null=False)

