from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from django.db import models

from User.models import User


# Register your models here.

@admin.register(User)
class SellerAdmin(UserAdmin):
    seller_admin_id = models.AutoField(primary_key=True)
    cashier_id = models.ForeignKey('Cashier', on_delete=models.CASCADE)
    add_fieldsets = (
        (
            None,
            {
                "classes": ("wide",),
                "fields": ("email", "phone", "usable_password", "password1", "password2", ),
            },
        ),
    )

    list_display = ['email', 'phone']
    list_display_links = ['email']
    list_editable = ["phone"]
    list_per_page = 10



