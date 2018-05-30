var arrLang = new Array();
arrLang['en'] = new Array();
arrLang['fr'] = new Array();

arrLang['en']['welcome'] = 'Welcome in DI';
arrLang['en']['di'] = 'DI';
arrLang['en']['dee'] = 'DEE';
arrLang['en']['language'] = 'Language';
arrLang['en']['chooseItinerary'] = 'Choose your itinerary';
arrLang['en']['PointStarting'] = 'Choose your starting point';
arrLang['en']['destination'] = 'Choose your point of arrival';
arrLang['en']['buttonItinerary'] = 'Search Itinerary';

arrLang['fr']['welcome'] = 'Bienvenue au DI';
arrLang['fr']['di'] = 'DI en fr';
arrLang['fr']['dee'] = 'DEE en fr';
arrLang['fr']['language'] = 'Langage';
arrLang['fr']['chooseItinerary'] = 'Choisissez votre itinéraire';
arrLang['fr']['PointStarting'] = 'Choisissez votre point de départ';
arrLang['fr']['destination'] = 'Choisissez votre point de départ';
arrLang['fr']['buttonItinerary'] = 'Recherche itinéraire';

$(document).ready(function(e)
{
    $('.translate').click(function()
    {
        var lang = $(this).attr('id');
        $('.lang').each(function(index, element)
        {
            $(this).text(arrLang[lang][$(this).attr('key')]);
        });
    });
});
