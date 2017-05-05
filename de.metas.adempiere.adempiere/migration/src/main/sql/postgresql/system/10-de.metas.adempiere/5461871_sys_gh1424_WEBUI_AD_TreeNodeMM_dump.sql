--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = backup, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: webui_ad_treenodemm; Type: TABLE; Schema: backup; Owner: metasfresh
--

CREATE TABLE webui_ad_treenodemm (
    ad_tree_id numeric(10,0),
    node_id numeric(10,0),
    ad_client_id numeric(10,0),
    ad_org_id numeric(10,0),
    isactive character(1),
    created timestamp with time zone,
    createdby numeric(10,0),
    updated timestamp with time zone,
    updatedby numeric(10,0),
    parent_id numeric(10,0),
    seqno numeric(10,0)
);


ALTER TABLE webui_ad_treenodemm OWNER TO metasfresh;

--
-- Data for Name: webui_ad_treenodemm; Type: TABLE DATA; Schema: backup; Owner: metasfresh
--

INSERT INTO webui_ad_treenodemm VALUES (1000039, 0, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, NULL, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540752, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540753, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540754, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540755, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540777, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540755, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540778, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540755, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540756, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540775, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540776, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 540752, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000008, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540815, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000021, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000023, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000024, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000025, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540816, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000028, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000029, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000032, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000090, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000091, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000025, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000042, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000008, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000009, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000034, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000035, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 8);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000037, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 9);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540794, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000037, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000096, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000037, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000044, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 7);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000089, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000092, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000093, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000009, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000010, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000040, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000010, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000046, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000010, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000048, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000010, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540738, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000048, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000050, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000010, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000097, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000010, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000011, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540785, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540786, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000041, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000047, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000049, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000051, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000011, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000012, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540791, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000012, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000052, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000012, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000053, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000012, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000061, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000012, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000069, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000012, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000013, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000054, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000013, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000062, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000013, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000070, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000013, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000080, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000013, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000014, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 7);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540800, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540805, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000055, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000063, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000071, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000081, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000014, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000015, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 8);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540749, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540758, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540759, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540779, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540803, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540806, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 7);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540814, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000056, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 8);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000064, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 9);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000072, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 10);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540780, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000072, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540810, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000072, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540812, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000072, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540813, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000072, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000082, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000015, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000016, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 9);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540796, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540797, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540798, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000057, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000065, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000075, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000016, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000017, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 10);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540736, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540781, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000058, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000066, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000076, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000083, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000017, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000018, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 11);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000059, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000067, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000077, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000085, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000086, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000104, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000018, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000019, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 12);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540728, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540782, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540783, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000060, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000068, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000079, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 7);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000087, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000019, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000098, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 0, 13);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 144, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 3);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 145, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 2);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 147, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 1);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 150, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540743, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 4);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540784, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 5);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000099, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 6);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 540809, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000099, 0);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000100, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 7);
INSERT INTO webui_ad_treenodemm VALUES (1000039, 1000101, 0, 0, 'Y', '2017-05-04 18:19:09.9202+02', 0, '2017-05-04 18:19:09.9202+02', 0, 1000098, 8);


--
-- PostgreSQL database dump complete
--

