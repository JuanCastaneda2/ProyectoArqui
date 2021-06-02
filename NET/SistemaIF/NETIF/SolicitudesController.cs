using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using SideCar;

namespace NETIF
{
    public class SolicitudesController : ApiController
    {
        private RentasEntities db = new RentasEntities();

        // GET: api/Solicitudes
        public IQueryable<Solicitud> GetSolicitud()
        {
            return db.Solicitud;
        }

        // GET: api/Solicitudes/5
        [ResponseType(typeof(Solicitud))]
        public IHttpActionResult GetSolicitud(int id)
        {
            Solicitud solicitud = db.Solicitud.Find(id);
            if (solicitud == null)
            {
                return NotFound();
            }

            return Ok(solicitud);
        }

        // PUT: api/Solicitudes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSolicitud(int id, Solicitud solicitud)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != solicitud.Id)
            {
                return BadRequest();
            }

            db.Entry(solicitud).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SolicitudExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Solicitudes
        [ResponseType(typeof(Solicitud))]
        public IHttpActionResult PostSolicitud(Solicitud solicitud)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Solicitud.Add(solicitud);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (SolicitudExists(solicitud.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = solicitud.Id }, solicitud);
        }

        // DELETE: api/Solicitudes/5
        [ResponseType(typeof(Solicitud))]
        public IHttpActionResult DeleteSolicitud(int id)
        {
            Solicitud solicitud = db.Solicitud.Find(id);
            if (solicitud == null)
            {
                return NotFound();
            }

            db.Solicitud.Remove(solicitud);
            db.SaveChanges();

            return Ok(solicitud);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SolicitudExists(int id)
        {
            return db.Solicitud.Count(e => e.Id == id) > 0;
        }

        // POST: api/Solicitudes/Nueva
        [HttpPost]
        [ResponseType(typeof(Solicitud))]
        public IHttpActionResult Nueva(Solicitud solicitud)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Solicitud.Add(solicitud);
            Usuario u = db.Usuario.Find(solicitud.IdUsuario);

            if (u.Discount((double)solicitud.Valor))
            {
                try
                {
                    db.SaveChanges();
                }
                catch (DbUpdateException)
                {
                    if (SolicitudExists(solicitud.Id))
                    {
                        return Conflict();
                    }
                    else
                    {
                        throw;
                    }
                }
            }
            return CreatedAtRoute("DefaultApi", new { id = solicitud.Id }, solicitud);
        }
    }
}