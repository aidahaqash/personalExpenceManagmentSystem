PGDMP                         z        	   Expensify    14.2    14.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            
           1262    16395 	   Expensify    DATABASE     o   CREATE DATABASE "Expensify" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Expensify";
                postgres    false            �            1259    16403    Expenses    TABLE     �   CREATE TABLE public."Expenses" (
    "userID" integer,
    "expenseID" integer NOT NULL,
    "expensesCategoryID" integer,
    "expenseName" text,
    "expenseValue" integer
);
    DROP TABLE public."Expenses";
       public         heap    postgres    false            �            1259    16415    ExpensesCategories    TABLE     �   CREATE TABLE public."ExpensesCategories" (
    "categoryID" integer NOT NULL,
    "userID" integer,
    "categoryName" text,
    "categoryColor" text,
    "categoryLogo" text,
    "categoryBudget" integer
);
 (   DROP TABLE public."ExpensesCategories";
       public         heap    postgres    false            �            1259    16410    Incomes    TABLE     �   CREATE TABLE public."Incomes" (
    "incomeID" integer NOT NULL,
    "userID" integer,
    "incomeCategoryID" integer,
    "incomeValue" integer
);
    DROP TABLE public."Incomes";
       public         heap    postgres    false            �            1259    16422    IncomesCategories    TABLE     �   CREATE TABLE public."IncomesCategories" (
    "IncomeCategoryID" integer NOT NULL,
    "userID" integer,
    "incomeID" integer,
    "incomeCategoryName" text
);
 '   DROP TABLE public."IncomesCategories";
       public         heap    postgres    false            �            1259    16396    Users    TABLE     w   CREATE TABLE public."Users" (
    "userID" integer NOT NULL,
    "fullName" text,
    email text,
    password text
);
    DROP TABLE public."Users";
       public         heap    postgres    false                      0    16403    Expenses 
   TABLE DATA           p   COPY public."Expenses" ("userID", "expenseID", "expensesCategoryID", "expenseName", "expenseValue") FROM stdin;
    public          postgres    false    210   5                 0    16415    ExpensesCategories 
   TABLE DATA           �   COPY public."ExpensesCategories" ("categoryID", "userID", "categoryName", "categoryColor", "categoryLogo", "categoryBudget") FROM stdin;
    public          postgres    false    212   R                 0    16410    Incomes 
   TABLE DATA           \   COPY public."Incomes" ("incomeID", "userID", "incomeCategoryID", "incomeValue") FROM stdin;
    public          postgres    false    211   o                 0    16422    IncomesCategories 
   TABLE DATA           m   COPY public."IncomesCategories" ("IncomeCategoryID", "userID", "incomeID", "incomeCategoryName") FROM stdin;
    public          postgres    false    213   �                  0    16396    Users 
   TABLE DATA           H   COPY public."Users" ("userID", "fullName", email, password) FROM stdin;
    public          postgres    false    209   �       r           2606    16421 *   ExpensesCategories ExpensesCategories_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public."ExpensesCategories"
    ADD CONSTRAINT "ExpensesCategories_pkey" PRIMARY KEY ("categoryID");
 X   ALTER TABLE ONLY public."ExpensesCategories" DROP CONSTRAINT "ExpensesCategories_pkey";
       public            postgres    false    212            n           2606    16409    Expenses Expenses_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public."Expenses"
    ADD CONSTRAINT "Expenses_pkey" PRIMARY KEY ("expenseID");
 D   ALTER TABLE ONLY public."Expenses" DROP CONSTRAINT "Expenses_pkey";
       public            postgres    false    210            t           2606    16428 (   IncomesCategories IncomesCategories_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."IncomesCategories"
    ADD CONSTRAINT "IncomesCategories_pkey" PRIMARY KEY ("IncomeCategoryID");
 V   ALTER TABLE ONLY public."IncomesCategories" DROP CONSTRAINT "IncomesCategories_pkey";
       public            postgres    false    213            p           2606    16414    Incomes Incomes_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Incomes"
    ADD CONSTRAINT "Incomes_pkey" PRIMARY KEY ("incomeID");
 B   ALTER TABLE ONLY public."Incomes" DROP CONSTRAINT "Incomes_pkey";
       public            postgres    false    211            l           2606    16402    Users Users_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY ("userID");
 >   ALTER TABLE ONLY public."Users" DROP CONSTRAINT "Users_pkey";
       public            postgres    false    209                  x������ � �            x������ � �            x������ � �            x������ � �          =   x�3�t�LIT�H,L,��L�KR�3���K2���s3s���s9��ML��-�b���� <�     