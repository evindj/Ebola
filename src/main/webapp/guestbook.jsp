<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLConnection" %>

<%@ page import="inno.test.ebola.helpers.FacebookHelper" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Ebola hero</title>
     <!-- viewport settings -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
      
        <link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-responsive.css">
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css"> 
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript" src="js/ebola_maps.js"></script>
</head>

<body onLoad="load()">





 <header >

            <!-- Nav -->
            <nav class="navbar" role="navigation">
                <div class="navbar-inner">
                    <div class="container">
                        <ul class="nav">
                            <li ><a href="index.html">Outbreak map</a></li>
                            <%
    String fbURL = "http://www.facebook.com/dialog/oauth?client_id=315817055276955&redirect_uri=" + URLEncoder.encode("http://thermal-well-768.appspot.com/sign") + "&scope=publish_stream,offline_access"+"&ext_perm=offline_access";
%>
                            <li class="active"><a href="<%=fbURL %>">Be a Hero</a></li>
                           
                        </ul>
                    </div>
                </div>
            </nav>		
        </header>

        <div class="container">
            <div class="row">
                <h4>Current Ebola outbreak;</h4>
                
                <div id="gmap_canvas" style="width:100%; height:640px;"></div>
            </div>
        </div>
        <footer>		</footer>

        
         <script src="js/jquery-1.11.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

</body>
</html>
