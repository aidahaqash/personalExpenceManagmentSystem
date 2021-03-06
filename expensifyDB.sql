PGDMP                         z        	   Expensify    14.2    14.2 '               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16395 	   Expensify    DATABASE     o   CREATE DATABASE "Expensify" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Expensify";
                postgres    false            ?            1259    16496    expenses    TABLE     ?   CREATE TABLE public.expenses (
    expenseid integer NOT NULL,
    userid integer,
    expensecategoryid integer,
    expensename text,
    expensevalue integer,
    expensedate date
);
    DROP TABLE public.expenses;
       public         heap    postgres    false            ?            1259    16495    expenses_expenseid_seq    SEQUENCE     ?   CREATE SEQUENCE public.expenses_expenseid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.expenses_expenseid_seq;
       public          postgres    false    212                       0    0    expenses_expenseid_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.expenses_expenseid_seq OWNED BY public.expenses.expenseid;
          public          postgres    false    211            ?            1259    16505    expensescategories    TABLE     ?   CREATE TABLE public.expensescategories (
    categoryid integer NOT NULL,
    userid integer,
    categoryname text,
    categorycolor text,
    categorylogo text,
    categorybudget integer
);
 &   DROP TABLE public.expensescategories;
       public         heap    postgres    false            ?            1259    16504 !   expensescategories_categoryid_seq    SEQUENCE     ?   CREATE SEQUENCE public.expensescategories_categoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.expensescategories_categoryid_seq;
       public          postgres    false    214                       0    0 !   expensescategories_categoryid_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.expensescategories_categoryid_seq OWNED BY public.expensescategories.categoryid;
          public          postgres    false    213            ?            1259    16514    incomes     TABLE     ?   CREATE TABLE public."incomes " (
    incomeid integer NOT NULL,
    userid integer,
    incomecategoryid integer,
    incomevalue integer,
    incomedate date
);
    DROP TABLE public."incomes ";
       public         heap    postgres    false            ?            1259    16513    incomes _incomeid_seq    SEQUENCE     ?   CREATE SEQUENCE public."incomes _incomeid_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."incomes _incomeid_seq";
       public          postgres    false    216                       0    0    incomes _incomeid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."incomes _incomeid_seq" OWNED BY public."incomes ".incomeid;
          public          postgres    false    215            ?            1259    16521    incomescategories    TABLE     ?   CREATE TABLE public.incomescategories (
    incomecategoryid integer NOT NULL,
    userid integer,
    incomeid integer,
    incomecategoryname text
);
 %   DROP TABLE public.incomescategories;
       public         heap    postgres    false            ?            1259    16520 &   incomescategories_incomecategoryid_seq    SEQUENCE     ?   CREATE SEQUENCE public.incomescategories_incomecategoryid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.incomescategories_incomecategoryid_seq;
       public          postgres    false    218                       0    0 &   incomescategories_incomecategoryid_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.incomescategories_incomecategoryid_seq OWNED BY public.incomescategories.incomecategoryid;
          public          postgres    false    217            ?            1259    16487    sign    TABLE     r   CREATE TABLE public.sign (
    uid integer NOT NULL,
    name text,
    email text NOT NULL,
    password text
);
    DROP TABLE public.sign;
       public         heap    postgres    false            ?            1259    16486    sign_uid_seq    SEQUENCE     ?   CREATE SEQUENCE public.sign_uid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.sign_uid_seq;
       public          postgres    false    210                       0    0    sign_uid_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.sign_uid_seq OWNED BY public.sign.uid;
          public          postgres    false    209            q           2604    16499    expenses expenseid    DEFAULT     x   ALTER TABLE ONLY public.expenses ALTER COLUMN expenseid SET DEFAULT nextval('public.expenses_expenseid_seq'::regclass);
 A   ALTER TABLE public.expenses ALTER COLUMN expenseid DROP DEFAULT;
       public          postgres    false    212    211    212            r           2604    16508    expensescategories categoryid    DEFAULT     ?   ALTER TABLE ONLY public.expensescategories ALTER COLUMN categoryid SET DEFAULT nextval('public.expensescategories_categoryid_seq'::regclass);
 L   ALTER TABLE public.expensescategories ALTER COLUMN categoryid DROP DEFAULT;
       public          postgres    false    213    214    214            s           2604    16517    incomes  incomeid    DEFAULT     z   ALTER TABLE ONLY public."incomes " ALTER COLUMN incomeid SET DEFAULT nextval('public."incomes _incomeid_seq"'::regclass);
 B   ALTER TABLE public."incomes " ALTER COLUMN incomeid DROP DEFAULT;
       public          postgres    false    216    215    216            t           2604    16524 "   incomescategories incomecategoryid    DEFAULT     ?   ALTER TABLE ONLY public.incomescategories ALTER COLUMN incomecategoryid SET DEFAULT nextval('public.incomescategories_incomecategoryid_seq'::regclass);
 Q   ALTER TABLE public.incomescategories ALTER COLUMN incomecategoryid DROP DEFAULT;
       public          postgres    false    218    217    218            p           2604    16490    sign uid    DEFAULT     d   ALTER TABLE ONLY public.sign ALTER COLUMN uid SET DEFAULT nextval('public.sign_uid_seq'::regclass);
 7   ALTER TABLE public.sign ALTER COLUMN uid DROP DEFAULT;
       public          postgres    false    210    209    210                      0    16496    expenses 
   TABLE DATA           p   COPY public.expenses (expenseid, userid, expensecategoryid, expensename, expensevalue, expensedate) FROM stdin;
    public          postgres    false    212   8,                 0    16505    expensescategories 
   TABLE DATA           {   COPY public.expensescategories (categoryid, userid, categoryname, categorycolor, categorylogo, categorybudget) FROM stdin;
    public          postgres    false    214   U,                 0    16514    incomes  
   TABLE DATA           a   COPY public."incomes " (incomeid, userid, incomecategoryid, incomevalue, incomedate) FROM stdin;
    public          postgres    false    216   r,                 0    16521    incomescategories 
   TABLE DATA           c   COPY public.incomescategories (incomecategoryid, userid, incomeid, incomecategoryname) FROM stdin;
    public          postgres    false    218   ?,                 0    16487    sign 
   TABLE DATA           :   COPY public.sign (uid, name, email, password) FROM stdin;
    public          postgres    false    210   ?,                  0    0    expenses_expenseid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.expenses_expenseid_seq', 1, false);
          public          postgres    false    211                        0    0 !   expensescategories_categoryid_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.expensescategories_categoryid_seq', 1, false);
          public          postgres    false    213            !           0    0    incomes _incomeid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."incomes _incomeid_seq"', 1, false);
          public          postgres    false    215            "           0    0 &   incomescategories_incomecategoryid_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.incomescategories_incomecategoryid_seq', 1, false);
          public          postgres    false    217            #           0    0    sign_uid_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.sign_uid_seq', 14, true);
          public          postgres    false    209            x           2606    16503    expenses expenses_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.expenses
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (expenseid);
 @   ALTER TABLE ONLY public.expenses DROP CONSTRAINT expenses_pkey;
       public            postgres    false    212            z           2606    16512 *   expensescategories expensescategories_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.expensescategories
    ADD CONSTRAINT expensescategories_pkey PRIMARY KEY (categoryid);
 T   ALTER TABLE ONLY public.expensescategories DROP CONSTRAINT expensescategories_pkey;
       public            postgres    false    214            |           2606    16519    incomes  incomes _pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."incomes "
    ADD CONSTRAINT "incomes _pkey" PRIMARY KEY (incomeid);
 D   ALTER TABLE ONLY public."incomes " DROP CONSTRAINT "incomes _pkey";
       public            postgres    false    216            ~           2606    16528 (   incomescategories incomescategories_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.incomescategories
    ADD CONSTRAINT incomescategories_pkey PRIMARY KEY (incomecategoryid);
 R   ALTER TABLE ONLY public.incomescategories DROP CONSTRAINT incomescategories_pkey;
       public            postgres    false    218            v           2606    16494    sign sign_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.sign
    ADD CONSTRAINT sign_pkey PRIMARY KEY (uid, email);
 8   ALTER TABLE ONLY public.sign DROP CONSTRAINT sign_pkey;
       public            postgres    false    210    210                  x?????? ? ?            x?????? ? ?            x?????? ? ?            x?????? ? ?         ?   x?m?A?0???)8aZ@???C??Bc?LK??	??ve???????aBu?OO?}q?O?K?????Hbl??????Wm9	;?E?#n?<r?%X?zK_S?ˣ?????%?AKo?sS>?????4b?Z3?<?F(     