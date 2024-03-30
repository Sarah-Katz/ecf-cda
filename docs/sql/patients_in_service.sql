SELECT
    firstname,
    lastname
FROM
    patient p
    JOIN bed b ON b.id_patient = p.id_patient
    JOIN room r ON b.room_id = r.room_id
    JOIN service s ON r.id_service = s.id_service
    AND s.name = "Urgence";