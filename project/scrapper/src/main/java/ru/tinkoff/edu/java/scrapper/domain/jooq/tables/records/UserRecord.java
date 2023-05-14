/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.User;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record4<Long, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>user.CHAT_ID</code>.
     */
    public void setChatId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.CHAT_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getChatId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>user.USERNAME</code>.
     */
    public void setUsername(@NotNull String value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.USERNAME</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 1000000000)
    @NotNull
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user.FIRST_NAME</code>.
     */
    public void setFirstName(@Nullable String value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.FIRST_NAME</code>.
     */
    @Size(max = 1000000000)
    @Nullable
    public String getFirstName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user.LAST_NAME</code>.
     */
    public void setLastName(@Nullable String value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.LAST_NAME</code>.
     */
    @Size(max = 1000000000)
    @Nullable
    public String getLastName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row4<Long, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return User.USER.CHAT_ID;
    }

    @Override
    @NotNull
    public Field<String> field2() {
        return User.USER.USERNAME;
    }

    @Override
    @NotNull
    public Field<String> field3() {
        return User.USER.FIRST_NAME;
    }

    @Override
    @NotNull
    public Field<String> field4() {
        return User.USER.LAST_NAME;
    }

    @Override
    @NotNull
    public Long component1() {
        return getChatId();
    }

    @Override
    @NotNull
    public String component2() {
        return getUsername();
    }

    @Override
    @Nullable
    public String component3() {
        return getFirstName();
    }

    @Override
    @Nullable
    public String component4() {
        return getLastName();
    }

    @Override
    @NotNull
    public Long value1() {
        return getChatId();
    }

    @Override
    @NotNull
    public String value2() {
        return getUsername();
    }

    @Override
    @Nullable
    public String value3() {
        return getFirstName();
    }

    @Override
    @Nullable
    public String value4() {
        return getLastName();
    }

    @Override
    @NotNull
    public UserRecord value1(@NotNull Long value) {
        setChatId(value);
        return this;
    }

    @Override
    @NotNull
    public UserRecord value2(@NotNull String value) {
        setUsername(value);
        return this;
    }

    @Override
    @NotNull
    public UserRecord value3(@Nullable String value) {
        setFirstName(value);
        return this;
    }

    @Override
    @NotNull
    public UserRecord value4(@Nullable String value) {
        setLastName(value);
        return this;
    }

    @Override
    @NotNull
    public UserRecord values(@NotNull Long value1, @NotNull String value2, @Nullable String value3, @Nullable String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    @ConstructorProperties({ "chatId", "username", "firstName", "lastName" })
    public UserRecord(@NotNull Long chatId, @NotNull String username, @Nullable String firstName, @Nullable String lastName) {
        super(User.USER);

        setChatId(chatId);
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(ru.tinkoff.edu.java.scrapper.domain.jooq.tables.pojos.User value) {
        super(User.USER);

        if (value != null) {
            setChatId(value.getChatId());
            setUsername(value.getUsername());
            setFirstName(value.getFirstName());
            setLastName(value.getLastName());
        }
    }
}