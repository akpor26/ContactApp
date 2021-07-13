package com.kenneth.contactdetails;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactDAO_Impl implements ContactDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ContactModel> __insertionAdapterOfContactModel;

  private final EntityDeletionOrUpdateAdapter<ContactModel> __deletionAdapterOfContactModel;

  public ContactDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContactModel = new EntityInsertionAdapter<ContactModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ContactModel` (`name`,`phoneNumber`,`uid`) VALUES (?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContactModel value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhoneNumber());
        }
        stmt.bindLong(3, value.getUid());
      }
    };
    this.__deletionAdapterOfContactModel = new EntityDeletionOrUpdateAdapter<ContactModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ContactModel` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContactModel value) {
        stmt.bindLong(1, value.getUid());
      }
    };
  }

  @Override
  public void addContactItem(final ContactModel contactItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfContactModel.insert(contactItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ContactModel contactItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfContactModel.handle(contactItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ContactModel>> getAllContactItems() {
    final String _sql = "SELECT * from contactmodel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"contactmodel"}, false, new Callable<List<ContactModel>>() {
      @Override
      public List<ContactModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final List<ContactModel> _result = new ArrayList<ContactModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ContactModel _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item = new ContactModel(_tmpName,_tmpPhoneNumber,_tmpUid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
