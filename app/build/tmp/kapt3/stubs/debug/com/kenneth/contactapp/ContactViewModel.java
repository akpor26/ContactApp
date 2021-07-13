package com.kenneth.contactapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/kenneth/contactapp/ContactViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addContactItem", "", "contactItem", "Lcom/kenneth/contactapp/ContactModel;", "database", "Lcom/kenneth/contactapp/ContactDatabase;", "getAllContactItems", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class ContactViewModel extends androidx.lifecycle.ViewModel {
    
    public ContactViewModel() {
        super();
    }
    
    public final void addContactItem(@org.jetbrains.annotations.NotNull
    com.kenneth.contactapp.ContactModel contactItem, @org.jetbrains.annotations.NotNull
    com.kenneth.contactapp.ContactDatabase database) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.kenneth.contactapp.ContactModel>> getAllContactItems(@org.jetbrains.annotations.NotNull
    com.kenneth.contactapp.ContactDatabase database) {
        return null;
    }
}