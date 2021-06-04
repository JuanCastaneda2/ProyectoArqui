﻿using SideCar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace ConsumidorWSLocalizacion.Controllers
{
    public class RentasController : Controller
    {
        string base_url = "http://localhost:8080";

        [HttpGet]
        public ActionResult Index()
        {
            ViewBag.Locaciones = ObtenerListado();
            return View();
        }

        [HttpGet]
        public ActionResult Listar(string id)
        {
            IEnumerable<Rentar> rentas = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/WSRentas/resources/managerrentas/");
                //HTTP GET              
                var responseTask = client.GetAsync("localizacion/"+id);
                responseTask.Wait();
                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<IList<Rentar>>();
                    readTask.Wait();

                    rentas = readTask.Result;
                }
                else //web api sent error response 
                {
                    //log response status here..

                    rentas = Enumerable.Empty<Rentar>();

                    ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
                }
            }
            return View(rentas);

        }

        public List<SelectListItem> ObtenerListado()
        {
            return new List<SelectListItem>()
            {
                new SelectListItem()
                {
                    Text = "Seleccione una opción",
                    Value = "0",
                    Disabled = true
                },
                new SelectListItem()
                {
                    Text = "Colina",
                    Value = "1"
                },
                new SelectListItem()
                {
                    Text = "Santa Isabel",
                    Value = "2"
                },
                new SelectListItem()
                {
                    Text = "Usaquen",
                    Value = "3"
                }
            };
        }

    }
}
