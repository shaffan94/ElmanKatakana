-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25 Jul 2018 pada 07.42
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `katakana`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bobot`
--

CREATE TABLE `bobot` (
  `id_bobot` int(6) NOT NULL,
  `layer` enum('input_hidden','context_hidden','hiden_output') NOT NULL,
  `target` varchar(10) NOT NULL,
  `bobot` double NOT NULL,
  `indexI` int(6) NOT NULL,
  `indexJ` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bobot`
--

INSERT INTO `bobot` (`id_bobot`, `layer`, `target`, `bobot`, `indexI`, `indexJ`) VALUES
(4716, 'input_hidden', 'i', 77.67804916418362, 0, 0),
(4717, 'input_hidden', 'i', 69.10672885239528, 0, 1),
(4718, 'input_hidden', 'i', 23.414830565814277, 0, 2),
(4719, 'input_hidden', 'i', -30.744574123421017, 0, 3),
(4720, 'input_hidden', 'i', 108.24423516246016, 1, 0),
(4721, 'input_hidden', 'i', 97.90042319278955, 1, 1),
(4722, 'input_hidden', 'i', 33.38322855646635, 1, 2),
(4723, 'input_hidden', 'i', -42.30039258898554, 1, 3),
(4724, 'input_hidden', 'i', 153.23832923084296, 2, 0),
(4725, 'input_hidden', 'i', 137.45518860700597, 2, 1),
(4726, 'input_hidden', 'i', 46.083613085449755, 2, 2),
(4727, 'input_hidden', 'i', -59.02967306793625, 2, 3),
(4728, 'input_hidden', 'i', 80.40146576728358, 3, 0),
(4729, 'input_hidden', 'i', 71.34335373383679, 3, 1),
(4730, 'input_hidden', 'i', 23.95525612450118, 3, 2),
(4731, 'input_hidden', 'i', -30.801303949110686, 3, 3),
(4732, 'input_hidden', 'i', 28.754521436711773, 4, 0),
(4733, 'input_hidden', 'i', 25.83994973079377, 4, 1),
(4734, 'input_hidden', 'i', 8.659437948498889, 4, 2),
(4735, 'input_hidden', 'i', -11.252470153623818, 4, 3),
(4736, 'input_hidden', 'i', 34.96053285906742, 5, 0),
(4737, 'input_hidden', 'i', 30.76619779132361, 5, 1),
(4738, 'input_hidden', 'i', 11.278044454960185, 5, 2),
(4739, 'input_hidden', 'i', -13.813747467658347, 5, 3),
(4740, 'input_hidden', 'i', 0.7656221651028139, 6, 0),
(4741, 'input_hidden', 'i', -0.7648741085173736, 6, 1),
(4742, 'input_hidden', 'i', -0.025240164037925172, 6, 2),
(4743, 'input_hidden', 'i', 0.3541803943343227, 6, 3),
(4744, 'input_hidden', 'i', 81.66626428125848, 7, 0),
(4745, 'input_hidden', 'i', 71.66578803432706, 7, 1),
(4746, 'input_hidden', 'i', 24.000805837317593, 7, 2),
(4747, 'input_hidden', 'i', -32.06757179762547, 7, 3),
(4748, 'input_hidden', 'i', 108.57923034398914, 8, 0),
(4749, 'input_hidden', 'i', 96.01533777693004, 8, 1),
(4750, 'input_hidden', 'i', 32.72421071742381, 8, 2),
(4751, 'input_hidden', 'i', -42.26196514255802, 8, 3),
(4752, 'input_hidden', 'i', 149.4962524417349, 9, 0),
(4753, 'input_hidden', 'i', 133.60621369810406, 9, 1),
(4754, 'input_hidden', 'i', 45.05089458921119, 9, 2),
(4755, 'input_hidden', 'i', -58.91461497371197, 9, 3),
(4756, 'context_hidden', 'i', 3550.0910616473993, 0, 0),
(4757, 'context_hidden', 'i', 3163.942544205619, 0, 1),
(4758, 'context_hidden', 'i', 1066.4924178338485, 0, 2),
(4759, 'context_hidden', 'i', -2.7469188290312845, 0, 3),
(4760, 'context_hidden', 'i', 3550.161293788333, 1, 0),
(4761, 'context_hidden', 'i', 3163.9192297271466, 1, 1),
(4762, 'context_hidden', 'i', 1065.18268700284, 1, 2),
(4763, 'context_hidden', 'i', -1.7680274533968772, 1, 3),
(4764, 'context_hidden', 'i', 3548.5518892623004, 2, 0),
(4765, 'context_hidden', 'i', 3162.2231731251923, 2, 1),
(4766, 'context_hidden', 'i', 1065.7878158069218, 2, 2),
(4767, 'context_hidden', 'i', -1.6323379720356685, 2, 3),
(4768, 'context_hidden', 'i', 3549.1568931622205, 3, 0),
(4769, 'context_hidden', 'i', 3162.680125893438, 3, 1),
(4770, 'context_hidden', 'i', 1065.3031860140738, 3, 2),
(4771, 'context_hidden', 'i', -2.7881340153058956, 3, 3),
(4772, 'hiden_output', 'i', -2.103132728636293, 0, 0),
(4773, 'hiden_output', 'i', -2.2725750368722584, 0, 1),
(4774, 'hiden_output', 'i', -1.61427039618549, 0, 2),
(4775, 'hiden_output', 'i', -2.2737931362557555, 0, 3),
(4776, 'hiden_output', 'i', -1.086527678205844, 0, 4),
(4777, 'hiden_output', 'i', 1.6021091330081891, 0, 5),
(4778, 'hiden_output', 'i', -1.6113717120329707, 1, 0),
(4779, 'hiden_output', 'i', -1.4599189920328477, 1, 1),
(4780, 'hiden_output', 'i', -1.8771848610142905, 1, 2),
(4781, 'hiden_output', 'i', -1.391702313694639, 1, 3),
(4782, 'hiden_output', 'i', -1.7852564058829967, 1, 4),
(4783, 'hiden_output', 'i', 2.248417133224208, 1, 5),
(4784, 'hiden_output', 'i', -0.8764693204589724, 2, 0),
(4785, 'hiden_output', 'i', -0.8544088831247608, 2, 1),
(4786, 'hiden_output', 'i', -1.1015392797089805, 2, 2),
(4787, 'hiden_output', 'i', -0.9237399147968821, 2, 3),
(4788, 'hiden_output', 'i', -1.7550324457124946, 2, 4),
(4789, 'hiden_output', 'i', 0.7351337760764944, 2, 5),
(4790, 'hiden_output', 'i', -0.271098096201976, 3, 0),
(4791, 'hiden_output', 'i', -0.53884359081613, 3, 1),
(4792, 'hiden_output', 'i', 0.560754781601524, 3, 2),
(4793, 'hiden_output', 'i', 0.18709838006633128, 3, 3),
(4794, 'hiden_output', 'i', 0.37494870392363394, 3, 4),
(4795, 'hiden_output', 'i', -0.21229323739074885, 3, 5),
(4796, 'input_hidden', 'u', 74.4479207707053, 0, 0),
(4797, 'input_hidden', 'u', 68.08973402117071, 0, 1),
(4798, 'input_hidden', 'u', 43.57010590409591, 0, 2),
(4799, 'input_hidden', 'u', 29.27107882835316, 0, 3),
(4800, 'input_hidden', 'u', 54.24441595945046, 1, 0),
(4801, 'input_hidden', 'u', 48.4642672914238, 1, 1),
(4802, 'input_hidden', 'u', 30.559458450655658, 1, 2),
(4803, 'input_hidden', 'u', 21.963675959720003, 1, 3),
(4804, 'input_hidden', 'u', 82.81768073173062, 2, 0),
(4805, 'input_hidden', 'u', 74.81993145270766, 2, 1),
(4806, 'input_hidden', 'u', 48.1259336092807, 2, 2),
(4807, 'input_hidden', 'u', 31.31159552632126, 2, 3),
(4808, 'input_hidden', 'u', 39.52154960402134, 3, 0),
(4809, 'input_hidden', 'u', 34.93952859888471, 3, 1),
(4810, 'input_hidden', 'u', 22.549333012702732, 3, 2),
(4811, 'input_hidden', 'u', 15.771357013761694, 3, 3),
(4812, 'input_hidden', 'u', 23.492224972832336, 4, 0),
(4813, 'input_hidden', 'u', 20.45299027420839, 4, 1),
(4814, 'input_hidden', 'u', 11.978693238365018, 4, 2),
(4815, 'input_hidden', 'u', 8.672968215194324, 4, 3),
(4816, 'input_hidden', 'u', 16.958303482264327, 5, 0),
(4817, 'input_hidden', 'u', 15.454952779804037, 5, 1),
(4818, 'input_hidden', 'u', 9.474169187656067, 5, 2),
(4819, 'input_hidden', 'u', 5.837143864851151, 5, 3),
(4820, 'input_hidden', 'u', -0.3020238070483763, 6, 0),
(4821, 'input_hidden', 'u', 0.26797345563368347, 6, 1),
(4822, 'input_hidden', 'u', 0.4060276616175167, 6, 2),
(4823, 'input_hidden', 'u', 0.3018987165827629, 6, 3),
(4824, 'input_hidden', 'u', 79.39106313443934, 7, 0),
(4825, 'input_hidden', 'u', 70.50367321350852, 7, 1),
(4826, 'input_hidden', 'u', 45.16691232402914, 7, 2),
(4827, 'input_hidden', 'u', 30.70942822610592, 7, 3),
(4828, 'input_hidden', 'u', 53.62820841412771, 8, 0),
(4829, 'input_hidden', 'u', 49.096055372044916, 8, 1),
(4830, 'input_hidden', 'u', 31.568071253840497, 8, 2),
(4831, 'input_hidden', 'u', 20.759247693188414, 8, 3),
(4832, 'input_hidden', 'u', 84.99271364736768, 9, 0),
(4833, 'input_hidden', 'u', 76.31350012217914, 9, 1),
(4834, 'input_hidden', 'u', 47.30674591248443, 9, 2),
(4835, 'input_hidden', 'u', 32.447746569996234, 9, 3),
(4836, 'context_hidden', 'u', 1483.102965983762, 0, 0),
(4837, 'context_hidden', 'u', 1328.7099824878042, 0, 1),
(4838, 'context_hidden', 'u', 847.0750671849136, 0, 2),
(4839, 'context_hidden', 'u', 578.3605583142444, 0, 3),
(4840, 'context_hidden', 'u', 1481.8180405880241, 1, 0),
(4841, 'context_hidden', 'u', 1330.117028794695, 1, 1),
(4842, 'context_hidden', 'u', 847.4136012482552, 1, 2),
(4843, 'context_hidden', 'u', 578.3555154812814, 1, 3),
(4844, 'context_hidden', 'u', 1482.2353341639785, 2, 0),
(4845, 'context_hidden', 'u', 1329.4599656485507, 2, 1),
(4846, 'context_hidden', 'u', 847.3856471046494, 2, 2),
(4847, 'context_hidden', 'u', 578.9223099852961, 2, 3),
(4848, 'context_hidden', 'u', 1483.0693290227405, 3, 0),
(4849, 'context_hidden', 'u', 1328.693356536635, 3, 1),
(4850, 'context_hidden', 'u', 847.6722600790962, 3, 2),
(4851, 'context_hidden', 'u', 578.8926023085286, 3, 3),
(4852, 'hiden_output', 'u', -2.1032647237654767, 0, 0),
(4853, 'hiden_output', 'u', -0.9065014414160497, 0, 1),
(4854, 'hiden_output', 'u', -1.4061256406655656, 0, 2),
(4855, 'hiden_output', 'u', -1.3527043448288827, 0, 3),
(4856, 'hiden_output', 'u', 0.5208956253095609, 0, 4),
(4857, 'hiden_output', 'u', -1.9043955010533729, 0, 5),
(4858, 'hiden_output', 'u', -0.6794029769118813, 1, 0),
(4859, 'hiden_output', 'u', -1.6709644245759776, 1, 1),
(4860, 'hiden_output', 'u', -1.1841659911113667, 1, 2),
(4861, 'hiden_output', 'u', -1.956979701432651, 1, 3),
(4862, 'hiden_output', 'u', 1.6643735232754495, 1, 4),
(4863, 'hiden_output', 'u', -0.5712833724457038, 1, 5),
(4864, 'hiden_output', 'u', -1.0841320190693118, 2, 0),
(4865, 'hiden_output', 'u', -1.3909890454518088, 2, 1),
(4866, 'hiden_output', 'u', -0.7480614418799125, 2, 2),
(4867, 'hiden_output', 'u', -0.8877816182040195, 2, 3),
(4868, 'hiden_output', 'u', 0.9705220983519017, 2, 4),
(4869, 'hiden_output', 'u', -1.4795061581180955, 2, 5),
(4870, 'hiden_output', 'u', -0.7256173822095698, 3, 0),
(4871, 'hiden_output', 'u', -0.6298013104779988, 3, 1),
(4872, 'hiden_output', 'u', -1.261693206699164, 3, 2),
(4873, 'hiden_output', 'u', -0.39295945819843886, 3, 3),
(4874, 'hiden_output', 'u', 1.4414274837361458, 3, 4),
(4875, 'hiden_output', 'u', -0.638134587800196, 3, 5),
(4876, 'input_hidden', 'a', 85.71402474217966, 0, 0),
(4877, 'input_hidden', 'a', 163.51662567715303, 0, 1),
(4878, 'input_hidden', 'a', -119.55083902481088, 0, 2),
(4879, 'input_hidden', 'a', 156.5712648415537, 0, 3),
(4880, 'input_hidden', 'a', 30.091929502541806, 1, 0),
(4881, 'input_hidden', 'a', 57.400463108124164, 1, 1),
(4882, 'input_hidden', 'a', -41.79639373190383, 1, 2),
(4883, 'input_hidden', 'a', 54.46104960662515, 1, 3),
(4884, 'input_hidden', 'a', 91.06422545650832, 2, 0),
(4885, 'input_hidden', 'a', 172.6578632814761, 2, 1),
(4886, 'input_hidden', 'a', -126.80001088209545, 2, 2),
(4887, 'input_hidden', 'a', 165.68107821738676, 2, 3),
(4888, 'input_hidden', 'a', 38.540427951040414, 3, 0),
(4889, 'input_hidden', 'a', 73.32992775719195, 3, 1),
(4890, 'input_hidden', 'a', -53.33445595961672, 3, 2),
(4891, 'input_hidden', 'a', 69.3039641532217, 3, 3),
(4892, 'input_hidden', 'a', 26.20012440500139, 4, 0),
(4893, 'input_hidden', 'a', 48.44037653186399, 4, 1),
(4894, 'input_hidden', 'a', -35.6168785031563, 4, 2),
(4895, 'input_hidden', 'a', 45.492891053047096, 4, 3),
(4896, 'input_hidden', 'a', 9.446052633883646, 5, 0),
(4897, 'input_hidden', 'a', 18.773989621018224, 5, 1),
(4898, 'input_hidden', 'a', -14.746780788485328, 5, 2),
(4899, 'input_hidden', 'a', 17.795005313944277, 5, 3),
(4900, 'input_hidden', 'a', 0.9801360032733695, 6, 0),
(4901, 'input_hidden', 'a', -0.9364934509211373, 6, 1),
(4902, 'input_hidden', 'a', -0.6215542837065611, 6, 2),
(4903, 'input_hidden', 'a', 0.35641204792921277, 6, 3),
(4904, 'input_hidden', 'a', 100.97260121635779, 7, 0),
(4905, 'input_hidden', 'a', 191.62720490061815, 7, 1),
(4906, 'input_hidden', 'a', -139.30253952424772, 7, 2),
(4907, 'input_hidden', 'a', 180.9811474098385, 7, 3),
(4908, 'input_hidden', 'a', 31.375605775873403, 8, 0),
(4909, 'input_hidden', 'a', 61.301034408019305, 8, 1),
(4910, 'input_hidden', 'a', -44.397532248371114, 8, 2),
(4911, 'input_hidden', 'a', 59.24529280821082, 8, 3),
(4912, 'input_hidden', 'a', 88.90794548461152, 9, 0),
(4913, 'input_hidden', 'a', 170.0885784405386, 9, 1),
(4914, 'input_hidden', 'a', -123.05087045248628, 9, 2),
(4915, 'input_hidden', 'a', 162.3815177147139, 9, 3),
(4916, 'context_hidden', 'a', 1182.2463406740535, 0, 0),
(4917, 'context_hidden', 'a', 2251.705226042917, 0, 1),
(4918, 'context_hidden', 'a', -1.771842883324072, 0, 2),
(4919, 'context_hidden', 'a', 2138.455376604158, 0, 3),
(4920, 'context_hidden', 'a', 1182.5392520486848, 1, 0),
(4921, 'context_hidden', 'a', 2251.380453833542, 1, 1),
(4922, 'context_hidden', 'a', -1.6882530378424663, 1, 2),
(4923, 'context_hidden', 'a', 2138.1090963683887, 1, 3),
(4924, 'context_hidden', 'a', 1182.126778098885, 2, 0),
(4925, 'context_hidden', 'a', 2250.9597437648717, 2, 1),
(4926, 'context_hidden', 'a', -1.551972891914382, 2, 2),
(4927, 'context_hidden', 'a', 2139.1624897142096, 2, 3),
(4928, 'context_hidden', 'a', 1182.4179505716793, 3, 0),
(4929, 'context_hidden', 'a', 2251.485668392516, 3, 1),
(4930, 'context_hidden', 'a', -1.2893644109241325, 3, 2),
(4931, 'context_hidden', 'a', 2138.9892394126673, 3, 3),
(4932, 'hiden_output', 'a', -1.3097133963732914, 0, 0),
(4933, 'hiden_output', 'a', -1.493667340591769, 0, 1),
(4934, 'hiden_output', 'a', -0.6537888096138557, 0, 2),
(4935, 'hiden_output', 'a', -1.2722420328112993, 0, 3),
(4936, 'hiden_output', 'a', -1.075216649325885, 0, 4),
(4937, 'hiden_output', 'a', -1.9652726428595833, 0, 5),
(4938, 'hiden_output', 'a', -1.9135172324254526, 1, 0),
(4939, 'hiden_output', 'a', -2.0324134281614277, 1, 1),
(4940, 'hiden_output', 'a', -1.5710391352707154, 1, 2),
(4941, 'hiden_output', 'a', -1.7523315273321325, 1, 3),
(4942, 'hiden_output', 'a', -2.18614220253078, 1, 4),
(4943, 'hiden_output', 'a', -0.7459090608071245, 1, 5),
(4944, 'hiden_output', 'a', 0.463843200447108, 2, 0),
(4945, 'hiden_output', 'a', 0.6415214233752878, 2, 1),
(4946, 'hiden_output', 'a', -0.30304036057559813, 2, 2),
(4947, 'hiden_output', 'a', 0.570639003055922, 2, 3),
(4948, 'hiden_output', 'a', 0.13589890242894423, 2, 4),
(4949, 'hiden_output', 'a', -0.05429734732072168, 2, 5),
(4950, 'hiden_output', 'a', -1.3757977106410693, 3, 0),
(4951, 'hiden_output', 'a', -1.068192960080443, 3, 1),
(4952, 'hiden_output', 'a', -2.3683379044865593, 3, 2),
(4953, 'hiden_output', 'a', -1.570075445125072, 3, 3),
(4954, 'hiden_output', 'a', -1.3327674460575312, 3, 4),
(4955, 'hiden_output', 'a', -1.8850193414743193, 3, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bobotbp`
--

CREATE TABLE `bobotbp` (
  `id_bobot` int(6) NOT NULL,
  `layer` enum('input_hidden','hidden_output') NOT NULL,
  `target` varchar(10) NOT NULL,
  `bobot` double NOT NULL,
  `indexI` int(6) NOT NULL,
  `indexJ` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bobotbp`
--

INSERT INTO `bobotbp` (`id_bobot`, `layer`, `target`, `bobot`, `indexI`, `indexJ`) VALUES
(3761, 'input_hidden', 'i', -0.23304423608857278, 0, 0),
(3762, 'input_hidden', 'i', -0.3820488261891167, 0, 1),
(3763, 'input_hidden', 'i', -0.1784954851631086, 0, 2),
(3764, 'input_hidden', 'i', -0.30133120620504167, 0, 3),
(3765, 'input_hidden', 'i', -0.3105990449808473, 1, 0),
(3766, 'input_hidden', 'i', 0.030915958965844065, 1, 1),
(3767, 'input_hidden', 'i', 0.07454213971140551, 1, 2),
(3768, 'input_hidden', 'i', 0.06546273475021225, 1, 3),
(3769, 'input_hidden', 'i', 0.017825170752180725, 2, 0),
(3770, 'input_hidden', 'i', -0.2873633385060457, 2, 1),
(3771, 'input_hidden', 'i', -0.2884116626167914, 2, 2),
(3772, 'input_hidden', 'i', -0.006888369545038367, 2, 3),
(3773, 'input_hidden', 'i', -0.29333924112351323, 3, 0),
(3774, 'input_hidden', 'i', -0.324735586182408, 3, 1),
(3775, 'input_hidden', 'i', -0.10059297963013367, 3, 2),
(3776, 'input_hidden', 'i', -0.3297021323874064, 3, 3),
(3777, 'input_hidden', 'i', -0.13695774268966188, 4, 0),
(3778, 'input_hidden', 'i', -0.12287221650365526, 4, 1),
(3779, 'input_hidden', 'i', -0.4559678638819494, 4, 2),
(3780, 'input_hidden', 'i', -0.04434139776673825, 4, 3),
(3781, 'input_hidden', 'i', -0.13898182130118825, 5, 0),
(3782, 'input_hidden', 'i', -0.4439200100662274, 5, 1),
(3783, 'input_hidden', 'i', -0.43564608312318226, 5, 2),
(3784, 'input_hidden', 'i', -0.3560765128339828, 5, 3),
(3785, 'input_hidden', 'i', -0.1315816060543013, 6, 0),
(3786, 'input_hidden', 'i', -0.3170969753585322, 6, 1),
(3787, 'input_hidden', 'i', -0.03465899567803482, 6, 2),
(3788, 'input_hidden', 'i', -0.47633787671842776, 6, 3),
(3789, 'input_hidden', 'i', -0.25460623494340173, 7, 0),
(3790, 'input_hidden', 'i', -0.18271927266036936, 7, 1),
(3791, 'input_hidden', 'i', -0.023468949105602894, 7, 2),
(3792, 'input_hidden', 'i', -0.3327166450393719, 7, 3),
(3793, 'input_hidden', 'i', -0.28724045831640893, 8, 0),
(3794, 'input_hidden', 'i', -0.3782477190164695, 8, 1),
(3795, 'input_hidden', 'i', 0.05053582256476483, 8, 2),
(3796, 'input_hidden', 'i', -0.21654137513093696, 8, 3),
(3797, 'input_hidden', 'i', -0.25144580549572854, 9, 0),
(3798, 'input_hidden', 'i', -0.26062793640348525, 9, 1),
(3799, 'input_hidden', 'i', -0.1521578218683345, 9, 2),
(3800, 'input_hidden', 'i', -0.07979796834752444, 9, 3),
(3801, 'hidden_output', 'i', -1.586586505721494, 0, 0),
(3802, 'hidden_output', 'i', -1.3252436703466672, 0, 1),
(3803, 'hidden_output', 'i', -1.4987966198538063, 0, 2),
(3804, 'hidden_output', 'i', -1.38601609145564, 0, 3),
(3805, 'hidden_output', 'i', -1.5097950463751642, 0, 4),
(3806, 'hidden_output', 'i', 1.4063303826172449, 0, 5),
(3807, 'hidden_output', 'i', -1.4818498543995227, 1, 0),
(3808, 'hidden_output', 'i', -1.3891311968277846, 1, 1),
(3809, 'hidden_output', 'i', -1.5670410417450773, 1, 2),
(3810, 'hidden_output', 'i', -1.3300103675255577, 1, 3),
(3811, 'hidden_output', 'i', -1.2950477915401621, 1, 4),
(3812, 'hidden_output', 'i', 1.2615803180568004, 1, 5),
(3813, 'hidden_output', 'i', -1.529723830107309, 2, 0),
(3814, 'hidden_output', 'i', -1.631182982552629, 2, 1),
(3815, 'hidden_output', 'i', -1.368082437651377, 2, 2),
(3816, 'hidden_output', 'i', -1.464735763863629, 2, 3),
(3817, 'hidden_output', 'i', -1.5690444899103475, 2, 4),
(3818, 'hidden_output', 'i', 1.7550195246464944, 2, 5),
(3819, 'hidden_output', 'i', -1.1794082883174943, 3, 0),
(3820, 'hidden_output', 'i', -1.422045204041587, 3, 1),
(3821, 'hidden_output', 'i', -1.354168557780972, 3, 2),
(3822, 'hidden_output', 'i', -1.5764561671370785, 3, 3),
(3823, 'hidden_output', 'i', -1.3856400314389918, 3, 4),
(3824, 'hidden_output', 'i', 1.2826391893642888, 3, 5),
(3825, 'input_hidden', 'u', -0.18415215930725784, 0, 0),
(3826, 'input_hidden', 'u', 0.14256904928790592, 0, 1),
(3827, 'input_hidden', 'u', 0.09436455666004318, 0, 2),
(3828, 'input_hidden', 'u', -0.0718891893464765, 0, 3),
(3829, 'input_hidden', 'u', -0.0029431713806071075, 1, 0),
(3830, 'input_hidden', 'u', -0.0033647412550161333, 1, 1),
(3831, 'input_hidden', 'u', 0.0008535964766356994, 1, 2),
(3832, 'input_hidden', 'u', 0.04547129036920104, 1, 3),
(3833, 'input_hidden', 'u', 0.011603993313738667, 2, 0),
(3834, 'input_hidden', 'u', -0.2448413477891746, 2, 1),
(3835, 'input_hidden', 'u', 0.18506000083568877, 2, 2),
(3836, 'input_hidden', 'u', 0.03711260082379112, 2, 3),
(3837, 'input_hidden', 'u', -0.07213260329807042, 3, 0),
(3838, 'input_hidden', 'u', -0.3543506913745936, 3, 1),
(3839, 'input_hidden', 'u', -0.32024854373838463, 3, 2),
(3840, 'input_hidden', 'u', -0.296316035950807, 3, 3),
(3841, 'input_hidden', 'u', -0.11345663736551048, 4, 0),
(3842, 'input_hidden', 'u', 0.028055670064286185, 4, 1),
(3843, 'input_hidden', 'u', -0.2364442887335759, 4, 2),
(3844, 'input_hidden', 'u', -0.003023996108726515, 4, 3),
(3845, 'input_hidden', 'u', -0.01695869709049173, 5, 0),
(3846, 'input_hidden', 'u', 0.002864450434505929, 5, 1),
(3847, 'input_hidden', 'u', 0.0030298837602065784, 5, 2),
(3848, 'input_hidden', 'u', -0.04078366884034137, 5, 3),
(3849, 'input_hidden', 'u', -0.12754069565754794, 6, 0),
(3850, 'input_hidden', 'u', -0.42829545464824786, 6, 1),
(3851, 'input_hidden', 'u', -0.19108771577200756, 6, 2),
(3852, 'input_hidden', 'u', -0.24360806729825196, 6, 3),
(3853, 'input_hidden', 'u', -0.01866221980117681, 7, 0),
(3854, 'input_hidden', 'u', 0.1128187646231654, 7, 1),
(3855, 'input_hidden', 'u', -0.010693688556594826, 7, 2),
(3856, 'input_hidden', 'u', -0.3119938403964802, 7, 3),
(3857, 'input_hidden', 'u', -0.07564017409944422, 8, 0),
(3858, 'input_hidden', 'u', -0.14306027716562233, 8, 1),
(3859, 'input_hidden', 'u', -0.14792949766319508, 8, 2),
(3860, 'input_hidden', 'u', -0.15030062392581436, 8, 3),
(3861, 'input_hidden', 'u', -0.11734803534246341, 9, 0),
(3862, 'input_hidden', 'u', -0.21986522130531588, 9, 1),
(3863, 'input_hidden', 'u', -0.11324709276404261, 9, 2),
(3864, 'input_hidden', 'u', 0.022113695852561458, 9, 3),
(3865, 'hidden_output', 'u', -1.5292821973631, 0, 0),
(3866, 'hidden_output', 'u', -1.6015013745135684, 0, 1),
(3867, 'hidden_output', 'u', -1.2914657636590656, 0, 2),
(3868, 'hidden_output', 'u', -1.4787116949439523, 0, 3),
(3869, 'hidden_output', 'u', 1.5176505085943741, 0, 4),
(3870, 'hidden_output', 'u', -1.4542801094495317, 0, 5),
(3871, 'hidden_output', 'u', -1.2927142344445488, 1, 0),
(3872, 'hidden_output', 'u', -1.246342399893514, 1, 1),
(3873, 'hidden_output', 'u', -1.4379893421244017, 1, 2),
(3874, 'hidden_output', 'u', -1.3353023409370688, 1, 3),
(3875, 'hidden_output', 'u', 1.4611548650299484, 1, 4),
(3876, 'hidden_output', 'u', -1.3798703540569273, 1, 5),
(3877, 'hidden_output', 'u', -1.3985337257755897, 2, 0),
(3878, 'hidden_output', 'u', -1.5001448987946129, 2, 1),
(3879, 'hidden_output', 'u', -1.4746946985504157, 2, 2),
(3880, 'hidden_output', 'u', -1.2892029500541826, 2, 3),
(3881, 'hidden_output', 'u', 1.4288250717874447, 2, 4),
(3882, 'hidden_output', 'u', -1.534323943189211, 2, 5),
(3883, 'hidden_output', 'u', -1.4548932608755776, 3, 0),
(3884, 'hidden_output', 'u', -1.3210851983967167, 3, 1),
(3885, 'hidden_output', 'u', -1.4976837346729166, 3, 2),
(3886, 'hidden_output', 'u', -1.5698262976826893, 3, 3),
(3887, 'hidden_output', 'u', 1.2123438448048278, 3, 4),
(3888, 'hidden_output', 'u', -1.3116432283780148, 3, 5),
(3889, 'input_hidden', 'a', -0.18386374207927084, 0, 0),
(3890, 'input_hidden', 'a', -0.07329736145682968, 0, 1),
(3891, 'input_hidden', 'a', -0.1786214328333308, 0, 2),
(3892, 'input_hidden', 'a', -0.045212301531924445, 0, 3),
(3893, 'input_hidden', 'a', -0.20415759492658697, 1, 0),
(3894, 'input_hidden', 'a', -0.38644742313659053, 1, 1),
(3895, 'input_hidden', 'a', -0.07847585566145257, 1, 2),
(3896, 'input_hidden', 'a', -0.14433767481446214, 1, 3),
(3897, 'input_hidden', 'a', 0.12059937793974959, 2, 0),
(3898, 'input_hidden', 'a', -0.2439815609473388, 2, 1),
(3899, 'input_hidden', 'a', -0.0489587828023475, 2, 2),
(3900, 'input_hidden', 'a', 0.21306589055485933, 2, 3),
(3901, 'input_hidden', 'a', -0.30097794615565626, 3, 0),
(3902, 'input_hidden', 'a', -0.3778906009525313, 3, 1),
(3903, 'input_hidden', 'a', 0.06537617899259907, 3, 2),
(3904, 'input_hidden', 'a', -0.3481937633450422, 3, 3),
(3905, 'input_hidden', 'a', -0.15826653084422077, 4, 0),
(3906, 'input_hidden', 'a', -0.07569723437169021, 4, 1),
(3907, 'input_hidden', 'a', -0.3767380961058972, 4, 2),
(3908, 'input_hidden', 'a', -0.3190938916953886, 4, 3),
(3909, 'input_hidden', 'a', -0.18755712054085183, 5, 0),
(3910, 'input_hidden', 'a', -0.37091929853087746, 5, 1),
(3911, 'input_hidden', 'a', -0.10492396825493525, 5, 2),
(3912, 'input_hidden', 'a', -0.27976506138046736, 5, 3),
(3913, 'input_hidden', 'a', -0.33324251752303075, 6, 0),
(3914, 'input_hidden', 'a', -0.36324820156064574, 6, 1),
(3915, 'input_hidden', 'a', -0.46763140024686634, 6, 2),
(3916, 'input_hidden', 'a', -0.32229716297653577, 6, 3),
(3917, 'input_hidden', 'a', -0.14789037177829806, 7, 0),
(3918, 'input_hidden', 'a', 0.14049514404655936, 7, 1),
(3919, 'input_hidden', 'a', 0.226218220114803, 7, 2),
(3920, 'input_hidden', 'a', 0.0013915645983495538, 7, 3),
(3921, 'input_hidden', 'a', -0.1505727110537475, 8, 0),
(3922, 'input_hidden', 'a', -0.3218646884312046, 8, 1),
(3923, 'input_hidden', 'a', -0.3385332322009959, 8, 2),
(3924, 'input_hidden', 'a', -0.008975708157160162, 8, 3),
(3925, 'input_hidden', 'a', -0.24892859245527815, 9, 0),
(3926, 'input_hidden', 'a', -0.09168180053717555, 9, 1),
(3927, 'input_hidden', 'a', -0.1799945580187904, 9, 2),
(3928, 'input_hidden', 'a', -0.22563057299106937, 9, 3),
(3929, 'hidden_output', 'a', -1.3686488722844792, 0, 0),
(3930, 'hidden_output', 'a', -1.4420687676986943, 0, 1),
(3931, 'hidden_output', 'a', -1.3677267935998803, 0, 2),
(3932, 'hidden_output', 'a', -1.288357824825866, 0, 3),
(3933, 'hidden_output', 'a', -1.660834443965338, 0, 4),
(3934, 'hidden_output', 'a', -1.5810813043430887, 0, 5),
(3935, 'hidden_output', 'a', -1.5263969803093342, 1, 0),
(3936, 'hidden_output', 'a', -1.3277255126474812, 1, 1),
(3937, 'hidden_output', 'a', -1.2840109088685188, 1, 2),
(3938, 'hidden_output', 'a', -1.5858379999691348, 1, 3),
(3939, 'hidden_output', 'a', -1.4390882549595085, 1, 4),
(3940, 'hidden_output', 'a', -1.2312462863595508, 1, 5),
(3941, 'hidden_output', 'a', -1.3921718773551808, 2, 0),
(3942, 'hidden_output', 'a', -1.7042745324894404, 2, 1),
(3943, 'hidden_output', 'a', -1.572801757251899, 2, 2),
(3944, 'hidden_output', 'a', -1.5101350781170848, 2, 3),
(3945, 'hidden_output', 'a', -1.319831805994154, 2, 4),
(3946, 'hidden_output', 'a', -1.5963614078340442, 2, 5),
(3947, 'hidden_output', 'a', -1.4566838141104608, 3, 0),
(3948, 'hidden_output', 'a', -1.2524024514207275, 3, 1),
(3949, 'hidden_output', 'a', -1.493127100210675, 3, 2),
(3950, 'hidden_output', 'a', -1.3629515746953422, 3, 3),
(3951, 'hidden_output', 'a', -1.3015441147004534, 3, 4),
(3952, 'hidden_output', 'a', -1.3246259226098342, 3, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `output_target`
--

CREATE TABLE `output_target` (
  `id_output` int(11) NOT NULL,
  `indexI` int(11) NOT NULL,
  `output_ernn` double NOT NULL,
  `target` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `output_targetbp`
--

CREATE TABLE `output_targetbp` (
  `id_output` int(11) NOT NULL,
  `indexI` int(11) NOT NULL,
  `output_bp` double NOT NULL,
  `target` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `output_targetbp`
--

INSERT INTO `output_targetbp` (`id_output`, `indexI`, `output_bp`, `target`) VALUES
(349, 0, 0.05620917492830183, 'i'),
(350, 1, 0.05637930957535392, 'i'),
(351, 2, 0.05596223784810424, 'i'),
(352, 3, 0.05665145453911297, 'i'),
(353, 4, 0.05659375093872647, 'i'),
(354, 5, 0.9420214212929988, 'i'),
(355, 0, 0.05730399273496652, 'u'),
(356, 1, 0.057431798121511696, 'u'),
(357, 2, 0.05658958457719524, 'u'),
(358, 3, 0.05740876853578112, 'u'),
(359, 4, 0.9412374761183464, 'u'),
(360, 5, 0.057127753278255394, 'u'),
(361, 0, 0.05667505188398711, 'a'),
(362, 1, 0.05710861183595978, 'a'),
(363, 2, 0.05729010806437417, 'a'),
(364, 3, 0.05658719064721245, 'a'),
(365, 4, 0.057343059621361, 'a'),
(366, 5, 0.05693379260641871, 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bobot`
--
ALTER TABLE `bobot`
  ADD PRIMARY KEY (`id_bobot`);

--
-- Indexes for table `bobotbp`
--
ALTER TABLE `bobotbp`
  ADD PRIMARY KEY (`id_bobot`);

--
-- Indexes for table `output_target`
--
ALTER TABLE `output_target`
  ADD PRIMARY KEY (`id_output`);

--
-- Indexes for table `output_targetbp`
--
ALTER TABLE `output_targetbp`
  ADD PRIMARY KEY (`id_output`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bobot`
--
ALTER TABLE `bobot`
  MODIFY `id_bobot` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4956;

--
-- AUTO_INCREMENT for table `bobotbp`
--
ALTER TABLE `bobotbp`
  MODIFY `id_bobot` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3953;

--
-- AUTO_INCREMENT for table `output_target`
--
ALTER TABLE `output_target`
  MODIFY `id_output` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `output_targetbp`
--
ALTER TABLE `output_targetbp`
  MODIFY `id_output` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=367;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
