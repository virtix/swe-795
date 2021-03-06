
    alter table Mutation 
        drop constraint FK3772F6C9A47D2DEF;

    alter table MutationTestResult_Errors 
        drop constraint FKC0E8A2B240216BB7;

    alter table MutationTestResult_Errors 
        drop constraint FKC0E8A2B2D25D5A1D;

    alter table MutationTestResult_Passing 
        drop constraint FK851DA3CA40216BB7;

    alter table MutationTestResult_Passing 
        drop constraint FK851DA3CAD25D5A1D;

    alter table MutationTestResult_TestMessage 
        drop constraint FK67A12C2ED25D5A1D;

    alter table MutationTestResult_TestMessage 
        drop constraint FK67A12C2EC1D2AA43;

    alter table ViolatedInvariants 
        drop constraint FKC4306A552615D278;

    drop table Mutation if exists;

    drop table MutationTestResult if exists;

    drop table MutationTestResult_Errors if exists;

    drop table MutationTestResult_Passing if exists;

    drop table MutationTestResult_TestMessage if exists;

    drop table TestMessage if exists;

    drop table TestName if exists;

    drop table ViolatedInvariants if exists;

    create table Mutation (
        id bigint generated by default as identity (start with 1),
        addInfo varchar(255),
        className varchar(255),
        lineNumber integer not null,
        methodName varchar(255),
        mutationForLine integer not null,
        mutationType integer,
        mutationResult_id bigint,
        primary key (id),
        unique (className, lineNumber, mutationForLine, mutationType)
    );

    create table MutationTestResult (
        id bigint generated by default as identity (start with 1),
        date timestamp,
        differentViolatedInvariants integer not null,
        runs integer not null,
        totalViolations integer not null,
        touched bit not null,
        primary key (id)
    );

    create table MutationTestResult_Errors (
        mutationTestResult_id bigint not null,
        testMessage_id bigint not null,
        error_id integer not null,
        primary key (mutationTestResult_id, error_id),
        unique (testMessage_id)
    );

    create table MutationTestResult_Passing (
        mutationTestResult_id bigint not null,
        testMessage_id bigint not null,
        passing_id integer not null,
        primary key (mutationTestResult_id, passing_id),
        unique (testMessage_id)
    );

    create table MutationTestResult_TestMessage (
        MutationTestResult_id bigint not null,
        failures_id bigint not null,
        failure_list_id integer not null,
        primary key (MutationTestResult_id, failure_list_id),
        unique (failures_id)
    );

    create table TestMessage (
        id bigint generated by default as identity (start with 1),
        duration bigint not null,
        hasTouched bit not null,
        message longvarchar,
        testCaseName varchar(255),
        primary key (id)
    );

    create table TestName (
        id bigint generated by default as identity (start with 1),
        duration bigint not null,
        name varchar(1000),
        project varchar(255),
        primary key (id)
    );

    create table ViolatedInvariants (
        result_id bigint not null,
        violatedInvariant integer,
        violated_index integer not null,
        primary key (result_id, violated_index)
    );

    alter table Mutation 
        add constraint FK3772F6C9A47D2DEF 
        foreign key (mutationResult_id) 
        references MutationTestResult;

    alter table MutationTestResult_Errors 
        add constraint FKC0E8A2B240216BB7 
        foreign key (testMessage_id) 
        references TestMessage;

    alter table MutationTestResult_Errors 
        add constraint FKC0E8A2B2D25D5A1D 
        foreign key (mutationTestResult_id) 
        references MutationTestResult;

    alter table MutationTestResult_Passing 
        add constraint FK851DA3CA40216BB7 
        foreign key (testMessage_id) 
        references TestMessage;

    alter table MutationTestResult_Passing 
        add constraint FK851DA3CAD25D5A1D 
        foreign key (mutationTestResult_id) 
        references MutationTestResult;

    alter table MutationTestResult_TestMessage 
        add constraint FK67A12C2ED25D5A1D 
        foreign key (MutationTestResult_id) 
        references MutationTestResult;

    alter table MutationTestResult_TestMessage 
        add constraint FK67A12C2EC1D2AA43 
        foreign key (failures_id) 
        references TestMessage;

    alter table ViolatedInvariants 
        add constraint FKC4306A552615D278 
        foreign key (result_id) 
        references MutationTestResult;
