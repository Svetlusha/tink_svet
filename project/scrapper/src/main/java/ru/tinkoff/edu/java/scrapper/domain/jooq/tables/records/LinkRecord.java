/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.Link;


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
public class LinkRecord extends UpdatableRecordImpl<LinkRecord> implements Record8<Long, String, LocalDateTime, LocalDateTime, String, Integer, Integer, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>link.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>link.ID</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>link.URL</code>.
     */
    public void setUrl(@NotNull String value) {
        set(1, value);
    }

    /**
     * Getter for <code>link.URL</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 1000000000)
    @NotNull
    public String getUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>link.CHECKED_AT</code>.
     */
    public void setCheckedAt(@NotNull LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>link.CHECKED_AT</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public LocalDateTime getCheckedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>link.GH_PUSHED_AT</code>.
     */
    public void setGhPushedAt(@Nullable LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>link.GH_PUSHED_AT</code>.
     */
    @Nullable
    public LocalDateTime getGhPushedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>link.GH_DESCRIPTION</code>.
     */
    public void setGhDescription(@Nullable String value) {
        set(4, value);
    }

    /**
     * Getter for <code>link.GH_DESCRIPTION</code>.
     */
    @Size(max = 1000000000)
    @Nullable
    public String getGhDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>link.GH_FORKS_COUNT</code>.
     */
    public void setGhForksCount(@Nullable Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>link.GH_FORKS_COUNT</code>.
     */
    @Nullable
    public Integer getGhForksCount() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>link.SO_ANSWER_COUNT</code>.
     */
    public void setSoAnswerCount(@Nullable Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>link.SO_ANSWER_COUNT</code>.
     */
    @Nullable
    public Integer getSoAnswerCount() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>link.SO_LAST_EDIT_DATE</code>.
     */
    public void setSoLastEditDate(@Nullable LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>link.SO_LAST_EDIT_DATE</code>.
     */
    @Nullable
    public LocalDateTime getSoLastEditDate() {
        return (LocalDateTime) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row8<Long, String, LocalDateTime, LocalDateTime, String, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row8<Long, String, LocalDateTime, LocalDateTime, String, Integer, Integer, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return Link.LINK.ID;
    }

    @Override
    @NotNull
    public Field<String> field2() {
        return Link.LINK.URL;
    }

    @Override
    @NotNull
    public Field<LocalDateTime> field3() {
        return Link.LINK.CHECKED_AT;
    }

    @Override
    @NotNull
    public Field<LocalDateTime> field4() {
        return Link.LINK.GH_PUSHED_AT;
    }

    @Override
    @NotNull
    public Field<String> field5() {
        return Link.LINK.GH_DESCRIPTION;
    }

    @Override
    @NotNull
    public Field<Integer> field6() {
        return Link.LINK.GH_FORKS_COUNT;
    }

    @Override
    @NotNull
    public Field<Integer> field7() {
        return Link.LINK.SO_ANSWER_COUNT;
    }

    @Override
    @NotNull
    public Field<LocalDateTime> field8() {
        return Link.LINK.SO_LAST_EDIT_DATE;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @NotNull
    public String component2() {
        return getUrl();
    }

    @Override
    @NotNull
    public LocalDateTime component3() {
        return getCheckedAt();
    }

    @Override
    @Nullable
    public LocalDateTime component4() {
        return getGhPushedAt();
    }

    @Override
    @Nullable
    public String component5() {
        return getGhDescription();
    }

    @Override
    @Nullable
    public Integer component6() {
        return getGhForksCount();
    }

    @Override
    @Nullable
    public Integer component7() {
        return getSoAnswerCount();
    }

    @Override
    @Nullable
    public LocalDateTime component8() {
        return getSoLastEditDate();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @NotNull
    public String value2() {
        return getUrl();
    }

    @Override
    @NotNull
    public LocalDateTime value3() {
        return getCheckedAt();
    }

    @Override
    @Nullable
    public LocalDateTime value4() {
        return getGhPushedAt();
    }

    @Override
    @Nullable
    public String value5() {
        return getGhDescription();
    }

    @Override
    @Nullable
    public Integer value6() {
        return getGhForksCount();
    }

    @Override
    @Nullable
    public Integer value7() {
        return getSoAnswerCount();
    }

    @Override
    @Nullable
    public LocalDateTime value8() {
        return getSoLastEditDate();
    }

    @Override
    @NotNull
    public LinkRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value2(@NotNull String value) {
        setUrl(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value3(@NotNull LocalDateTime value) {
        setCheckedAt(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value4(@Nullable LocalDateTime value) {
        setGhPushedAt(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value5(@Nullable String value) {
        setGhDescription(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value6(@Nullable Integer value) {
        setGhForksCount(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value7(@Nullable Integer value) {
        setSoAnswerCount(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value8(@Nullable LocalDateTime value) {
        setSoLastEditDate(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord values(@NotNull Long value1, @NotNull String value2, @NotNull LocalDateTime value3, @Nullable LocalDateTime value4, @Nullable String value5, @Nullable Integer value6, @Nullable Integer value7, @Nullable LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LinkRecord
     */
    public LinkRecord() {
        super(Link.LINK);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    @ConstructorProperties({ "id", "url", "checkedAt", "ghPushedAt", "ghDescription", "ghForksCount", "soAnswerCount", "soLastEditDate" })
    public LinkRecord(@NotNull Long id, @NotNull String url, @NotNull LocalDateTime checkedAt, @Nullable LocalDateTime ghPushedAt, @Nullable String ghDescription, @Nullable Integer ghForksCount, @Nullable Integer soAnswerCount, @Nullable LocalDateTime soLastEditDate) {
        super(Link.LINK);

        setId(id);
        setUrl(url);
        setCheckedAt(checkedAt);
        setGhPushedAt(ghPushedAt);
        setGhDescription(ghDescription);
        setGhForksCount(ghForksCount);
        setSoAnswerCount(soAnswerCount);
        setSoLastEditDate(soLastEditDate);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    public LinkRecord(ru.tinkoff.edu.java.scrapper.domain.jooq.tables.pojos.Link value) {
        super(Link.LINK);

        if (value != null) {
            setId(value.getId());
            setUrl(value.getUrl());
            setCheckedAt(value.getCheckedAt());
            setGhPushedAt(value.getGhPushedAt());
            setGhDescription(value.getGhDescription());
            setGhForksCount(value.getGhForksCount());
            setSoAnswerCount(value.getSoAnswerCount());
            setSoLastEditDate(value.getSoLastEditDate());
        }
    }
}