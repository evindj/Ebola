// script JS coté client, Map API v3 ne donne plus la classe GDownloadUrl, nous devons nous même la définir

// definition de la fonction DowloardUrl qui téléchargera la ressource externe

 function load() {
      var config = {
            latitude  : 6.3165618,
            longitude : -10.8041695,
            location  : 'Monrovia, Liberia'
        };
 
        // Création d'un objet pLatLng pour stocker les coordonnées
        var latlng = new google.maps.LatLng(config.latitude, config.longitude);
 
        // Options de la carte
        var myOptions = {
            zoom: 2,
            center: latlng,
            // mapTypeId: google.maps.MapTypeId.SATELLITE
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
 
        // Création et affichage de la carte dans le div map_canvas
        var map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);

      // Change this depending on the name of your XML file
      downloadUrl("../Ebola_Info.xml", function(data) {
        var xml = data.responseXML;
        var markers = xml.documentElement.getElementsByTagName("marker");
        for (var i = 0; i < markers.length; i++) {
          createMarker(parseFloat(markers[i].getAttribute("lat")), parseFloat(markers[i].getAttribute("lng")), markers[i].getAttribute("titre"), markers[i].getAttribute("description"));
		  
        }
      });
	  
	  function createMarker(lat, lng, titre, description){ 
           var latlng = new google.maps.LatLng(lat, lng);
		   var markericon = '../img/Agent.png';
		   
           var marker = new google.maps.Marker({ 
             position: latlng, 
             map: map, 
             title: titre,
			 icon: markericon
            }); 

           var infobulle = new google.maps.InfoWindow({ 
             content: description 
            }); 
           google.maps.event.addListener(marker, 'click', function(){ 
             infobulle.open(map, marker); 
            }); 
          }
	    
    }

    function downloadUrl(url, callback) {
      var request = window.ActiveXObject ?
          new ActiveXObject('Microsoft.XMLHTTP') :
          new XMLHttpRequest;

      request.onreadystatechange = function() {
        if (request.readyState == 4) {
          request.onreadystatechange = doNothing;
          callback(request, request.status);
        }
      };

      request.open('GET', url, true);
      request.send(null);
    }

    function doNothing() {}	
	
window.onload = initialize;