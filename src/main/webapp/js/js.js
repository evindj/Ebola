 window.onload = function(){
        var config = {
            latitude  : 3.8303052,
            longitude : 11.5104532,
            location  : 'Yaounde, Cameroon'
        };
 
        // Cr�ation d'un objet pLatLng pour stocker les coordonn�es
        var latlng = new google.maps.LatLng(config.latitude, config.longitude);
 
        // Options de la carte
        var myOptions = {
            zoom: 13,
            center: latlng,
            // mapTypeId: google.maps.MapTypeId.SATELLITE
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
 
        // Cr�ation et affichage de la carte dans le div map_canvas
        var map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);
 
        // Ajout d'un marqueur sur la carte
        var mark = new google.maps.Marker({
            position: latlng,
            map:      map,
            title:    config.location
        });
    }