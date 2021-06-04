using Newtonsoft.Json;
using SideCar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace NetConsumer.Controllers
{
    public class NetRentaController : Controller
    {
        private readonly Random random = new Random();
        // GET: NetRenta
        public ActionResult Index()
        {
            return View();
        }

        // GET: NetRenta/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: NetRenta/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: NetRenta/Create
        [HttpPost]
        public ActionResult Index(FormCollection collection)
        {
            System.Diagnostics.Debug.WriteLine("Inicio metodo");
            try
            {
                IEnumerable<Solicitud> rentas = null;
                using (var client = new HttpClient())
                {
                    

                    Solicitud solicitud = new Solicitud
                    {
                        Id = random.Next(9999),
                        IdUsuario = Convert.ToInt32(collection["IdUsuario"]),
                        Contrasena = collection["Contrasena"],
                        Tipo = collection["Tipo"],
                        Valor = Convert.ToDouble(collection["Valor"])
                    };

                    var json = JsonConvert.SerializeObject(solicitud);
                    var data = new StringContent(json, Encoding.UTF8, "application/json");

                    var response = client.PostAsync("http://localhost:51346/api/Solicitudes/Nueva", data);
                    Console.WriteLine("Esperando....");
                    response.Wait();

                    var result = response.Result;
                    if (result.IsSuccessStatusCode)
                    {
                        Console.WriteLine("Resultado Positivo");

                        string resultString = result.Content.ReadAsStringAsync().Result;
                        Console.WriteLine(resultString);
                        //rentas = readTask.Result;
                    }
                    else //web api sent error response 
                    {
                        //log response status here..

                        //rentas = Enumerable.Empty<Solicitud>();

                        Console.WriteLine("Resultado Negativo");

                        ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
                    }
                }

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: NetRenta/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: NetRenta/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: NetRenta/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: NetRenta/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
