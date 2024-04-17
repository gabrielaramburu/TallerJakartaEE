insert into Usuario (username,passwordHash) values ('usr1','355d3dbbc5c190e36d4d5e7d2c1b78db0d28881d942a5bf90deddc3aa6789960');
insert into Usuario (username,passwordHash) values ('usr2','e5b0c292403177468df0a1cc8e2fe9d48d905507b12491fa95195fb976573808');
insert into Usuario (username,passwordHash) values ('usr3','0807ae093e07b9aaa3ae75f4ec5a8c5323b8a5550007093e4edf45e85a02f71e');
insert into Usuario (username,passwordHash) values ('usr4','0af6d47d5944b3fdfecd60c23a9b83224a989605633102aee0bf9cb0e6e48ea6');

insert into Grupo (nombre) values ('grupo1');
insert into Grupo (nombre) values ('grupo2');
insert into Grupo (nombre) values ('admin');

insert into Usuario_Grupo (Usuario_username, grupos_nombre) values ('usr1','grupo1');
insert into Usuario_Grupo (Usuario_username, grupos_nombre) values ('usr2','grupo2');
insert into Usuario_Grupo (Usuario_username, grupos_nombre) values ('usr3','grupo1');
insert into Usuario_Grupo (Usuario_username, grupos_nombre) values ('usr3','grupo2');
insert into Usuario_Grupo (Usuario_username, grupos_nombre) values ('usr4','admin');